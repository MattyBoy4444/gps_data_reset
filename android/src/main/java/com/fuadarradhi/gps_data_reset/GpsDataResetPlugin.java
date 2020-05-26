package com.fuadarradhi.gps_data_reset;

import android.annotation.TargetApi;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import static android.content.Context.LOCATION_SERVICE;

/** GpsDataResetPlugin */
public class GpsDataResetPlugin implements MethodCallHandler {
  private MethodChannel channel;
  private Registrar registrar;

  GpsDataResetPlugin(Registrar registrar){
    this.registrar = registrar;
  }

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "gps_data_reset");
    channel.setMethodCallHandler(new GpsDataResetPlugin(registrar));
  }

  @TargetApi(Build.VERSION_CODES.M)
  @Override
  public void onMethodCall(MethodCall call,Result result) {
    if (call.method.equals("resetAndDownload")) {
      LocationManager locationManager = (LocationManager) registrar.context().getSystemService(LOCATION_SERVICE);
      locationManager.sendExtraCommand(LocationManager.GPS_PROVIDER,"delete_aiding_data", null);

      Bundle bundle = new Bundle();
      locationManager.sendExtraCommand("gps", "force_xtra_injection", bundle);
      locationManager.sendExtraCommand("gps", "force_time_injection", bundle);
      result.success(true);
    } else {
      result.notImplemented();
    }
  }
}
