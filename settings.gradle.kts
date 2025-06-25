pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

// 👇 Add this block directly below
//val flutterSdkPath = File(rootDir, "flutter_module/.android/../..").canonicalPath
//val flutterSdkPath = "D:/AndroidLocal/Flutter/flutterSDK"
//includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
//        maven {
//            url = uri("$rootDir/flutter_module/build/host/outputs/repo")
//        }
        google()
        mavenCentral()
        maven("https://storage.googleapis.com/download.flutter.io")
    }
}


rootProject.name = "ComposableApp"
include(":app")
//adding custom flutter module
apply(from = File(rootDir, "flutter_module/.android/include_flutter.groovy"))
