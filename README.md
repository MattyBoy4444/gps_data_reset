### Usage

``` dart
import 'package:permission_handler/permission_handler.dart';
import 'package:gps_data_reset/gps_data_reset.dart';

if (await Permission.location.request().isGranted) {
    GpsDataReset.resetAndDownload();
}
```

## Permissions

### Android

On Android you'll need to add either the `ACCESS_COARSE_LOCATION` or the `ACCESS_LOCATION_EXTRA_COMMANDS` permission to your Android Manifest. To do so open the AndroidManifest.xml file (located under android/app/src/main) and add one of the following two lines as direct children of the `<manifest>` tag:

``` xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" />
```

## Author

This plugin for Flutter is developed by [Fuad Ar-Radhi](https://fuadarradhi.com).
