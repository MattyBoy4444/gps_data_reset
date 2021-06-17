import 'package:flutter/material.dart';
import 'package:gps_data_reset/gps_data_reset.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: TextButton(
            child: Text('Reset GPS Data'),
            onPressed: () async {
              GPSResetStatus status = await GPSDataReset.resetAndDownload();
              if (status == GPSResetStatus.SUCCESS) {
                print("Reset succes");
              } else if (status == GPSResetStatus.DENIED) {
                print("User rejected permission");
              } else if (status == GPSResetStatus.PERMANENTLY_DENIED) {
                GPSDataReset.openAppSettings();
              }
            },
          ),
        ),
      ),
    );
  }
}
