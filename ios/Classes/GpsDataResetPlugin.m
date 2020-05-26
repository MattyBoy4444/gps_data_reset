#import "GpsDataResetPlugin.h"
#if __has_include(<gps_data_reset/gps_data_reset-Swift.h>)
#import <gps_data_reset/gps_data_reset-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "gps_data_reset-Swift.h"
#endif

@implementation GpsDataResetPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftGpsDataResetPlugin registerWithRegistrar:registrar];
}
@end
