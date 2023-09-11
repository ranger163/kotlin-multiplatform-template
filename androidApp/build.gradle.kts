@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.compose)
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(rootProject.projects.shared)
            }
        }
    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = libs.versions.applicationId.get()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = libs.versions.applicationId.get()
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    kotlin {
        jvmToolchain(17)
    }
}

dependencies {
    implementation(libs.koinCore)
    implementation(libs.koinAndroid)
    implementation(libs.koinCompose)
}
