plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}

android {
    compileSdk = Versions.compileSdk
    namespace = Versions.applicationId

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = Versions.applicationId
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.VersionCode
        versionName = Versions.VersionName
    }
    compileOptions {
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlin {
        jvmToolchain(Versions.jdkVersion)
    }
}

dependencies {
    implementation(Dependencies.Android.libs)
    with(Dependencies.Koin) {
        implementation(core)
        implementation(android)
        implementation(compose)
    }
}
