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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("$rootDir/flutter_module/build/host/outputs/repo")
        }
        google()
        mavenCentral()
        maven("https://storage.googleapis.com/download.flutter.io")
    }
}

rootProject.name = "ComposableApp"
include(":app")
//adding custom flutter module
include(":flutter")
project(":flutter").projectDir = File(rootDir.parentFile, "flutter_module/.android")
