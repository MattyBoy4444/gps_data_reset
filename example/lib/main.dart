import 'package:flutter/material.dart';

import 'package:permission_handler/permission_handler.dart';
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
          child: FlatButton(child: Text("Reset and Download GPS"), onPressed: () async{
            if (await Permission.location.request().isGranted) {
              GpsDataReset.resetAndDownload();
            }
          },),
        ),
      ),
    );
  }
}
