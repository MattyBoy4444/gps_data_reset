import 'dart:async';

import 'package:flutter/services.dart';
import 'package:permission_handler/permission_handler.dart';

enum GPSResetStatus {
  SUCCESS,
  DENIED,
  PERMANENTLY_DENIED,
  ABORTED,
}

class GPSDataReset {
  static const MethodChannel _channel =
      const MethodChannel('flutter.fuadarradhi.com/gpsdatareset');

  /// Reset and Download GPS Data
  /// return:
  /// - SUCCESS : if reset success
  /// - DENIED  : or PERMANENTLY DENIED if user rejected permission
  /// - ABORTED : for others
  static Future<GPSResetStatus> resetAndDownload() async {
    if (await Permission.location.request().isGranted) {
      await _channel.invokeMethod('resetAndDownload');
      return GPSResetStatus.SUCCESS;
    } else {
      if (await Permission.location.isPermanentlyDenied) {
        return GPSResetStatus.PERMANENTLY_DENIED;
      } else if (await Permission.location.isDenied) {
        return GPSResetStatus.DENIED;
      }
    }
    return GPSResetStatus.ABORTED;
  }

  /// OpenAppSettings
  /// Just shortcut for call permission handler app setting
  static Future<void> openAppSettings() async {
    openAppSettings();
  }
}
