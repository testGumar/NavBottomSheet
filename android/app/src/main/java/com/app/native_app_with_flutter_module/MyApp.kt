package com.app.native_app_with_flutter_module

import android.app.Application;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load;
import com.facebook.react.defaults.DefaultReactHost;
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.soloader.SoLoader;
//import com.facebook.react.soloader.OpenSourceMergedSoMapping
import java.util.List;

class MyApp : Application(), ReactApplication {

//  override val reactNativeHost: ReactNativeHost = ReactNativeHostWrapper(
//          this,
//          object : DefaultReactNativeHost(this) {
//            override fun getPackages(): List<ReactPackage> {
//              val packages = PackageList(this).packages
//              // Packages that cannot be autolinked yet can be added manually here, for example:
//              // packages.add(MyReactNativePackage())
//              return packages
//            }
//
//            override fun getJSMainModuleName(): String = "index"//".expo/.virtual-metro-entry"
//
//            override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG
//
//            override val isNewArchEnabled: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
//            override val isHermesEnabled: Boolean = BuildConfig.IS_HERMES_ENABLED
//        }
//    )

    override val reactNativeHost: ReactNativeHost =
        object : DefaultReactNativeHost(this) {
            override fun getPackages(): MutableList<ReactPackage> = PackageList(this).packages.toMutableList()
            override fun getJSMainModuleName(): String = "index"
            override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG
            override val isNewArchEnabled: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
            override val isHermesEnabled: Boolean = BuildConfig.IS_HERMES_ENABLED
        }

    override val reactHost: ReactHost
        get() = getDefaultReactHost(applicationContext, reactNativeHost)

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, /*OpenSourceMergedSoMapping*/ false)
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            // If you opted-in for the New Architecture, we load the native entry point for this app.
            load()
        }
    }
}