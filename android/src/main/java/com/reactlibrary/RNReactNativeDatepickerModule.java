
package com.reactlibrary;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;


public class RNReactNativeDatepickerModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;

    public RNReactNativeDatepickerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }


    @Override
    public String getName() {
        return "RNReactNativeFtPicker";
    }

    public static void  sendEvent(String eventName,String date) {
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, date);
    }

}