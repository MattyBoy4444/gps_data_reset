import 'dart:async';

import 'package:flutter/services.dart';

class GpsDataReset {
  static const MethodChannel _channel =
      const MethodChannel('gps_data_reset');

  static Future<void> resetAndDownload() async {
    await _channel.invokeMethod('resetAndDownload');
  }
}
