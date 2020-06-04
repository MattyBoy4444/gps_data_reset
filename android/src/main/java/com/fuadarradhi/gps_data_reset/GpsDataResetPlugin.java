package com.fuadarradhi.gps_data_reset;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import static android.content.Context.LOCATION_SERVICE;

/** GpsDataResetPlugin */
public class GpsDataResetPlugin implements FlutterPlugin, MethodCallHandler {
  private MethodChannel methodChannel;
  private Context applicationContext;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final GpsDataResetPlugin gpsDataResetPlugin = new GpsDataResetPlugin();
    gpsDataResetPlugin.onAttachedToEngine(registrar.context(), registrar.messenger());
  }

  @Override
  public void onAttachedToEngine(FlutterPluginBinding binding) {
    onAttachedToEngine(binding.getApplicationContext(), binding.getBinaryMessenger());
  }

  private void onAttachedToEngine(Context applicationContext, BinaryMessenger messenger) {
    this.applicationContext = applicationContext;
    methodChannel = new MethodChannel(messenger, "flutter.fuadarradhi.com/gpsdatareset");
    methodChannel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("resetAndDownload")) {
      LocationManager locationManager = null;
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        locationManager = (LocationManager) applicationContext.getSystemService(LOCATION_SERVICE);
        locationManager.sendExtraCommand(LocationManager.GPS_PROVIDER, "delete_aiding_data", null);
        Bundle bundle = new Bundle();
        locationManager.sendExtraCommand(LocationManager.GPS_PROVIDER, "force_xtra_injection", bundle);
        locationManager.sendExtraCommand(LocationManager.GPS_PROVIDER, "force_time_injection", bundle);
      }
      result.success(true);
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(FlutterPluginBinding binding) {
    methodChannel.setMethodCallHandler(null);
  }
}
