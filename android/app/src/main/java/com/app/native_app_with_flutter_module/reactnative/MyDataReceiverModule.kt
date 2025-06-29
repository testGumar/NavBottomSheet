package com.app.native_app_with_flutter_module.reactnative

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import android.util.Log
import com.facebook.react.bridge.ReadableMap

class MyDataReceiverModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    override fun getName() = "MyDataReceiver"

    @ReactMethod
    fun sendDataToNative(message: ReadableMap) {
        Log.d("ReactToNative", "Received message: $message")
        // You can do more here: trigger an Android method, send a broadcast, update UI, etc.
    }
}