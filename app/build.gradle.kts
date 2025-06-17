plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.app.nbapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.app.nbapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // networking
    // okHttp + GSON + Retrofit
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    // GSON
    implementation(libs.gson)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
//    implementation(libs.retrofit2.kotlin.coroutines.adapter)

    // dagger hilt
    implementation(libs.hilt.dagger.android)
    ksp(libs.hilt.dagger.android.compiler)

    //composable
//    implementation(libs.compose.runtime) // compose runtime only


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}