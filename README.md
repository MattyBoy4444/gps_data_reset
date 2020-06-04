### Usage

``` dart
import 'package:gps_data_reset/gps_data_reset.dart';

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Center(
          child: FlatButton(
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
    );
  }
```

## Permissions

### Android

On Android you'll need to add either the `ACCESS_FINE_LOCATION` and the `ACCESS_LOCATION_EXTRA_COMMANDS` permission to your Android Manifest. To do so open the AndroidManifest.xml file (located under android/app/src/main) and add one of the following two lines as direct children of the `<manifest>` tag:

``` xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" />
```

## Author

This plugin for Flutter is developed by [Fuad Ar-Radhi](https://fuadarradhi.com).
