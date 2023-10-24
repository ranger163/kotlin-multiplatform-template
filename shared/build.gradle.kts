@file:Suppress("DSL_SCOPE_VIOLATION")

import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING


plugins {
    alias(libs.plugins.multiplatform)
    id(libs.plugins.native.cocoapods.get().pluginId)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.plugin.serialization)
    id(libs.plugins.plugin.buildKonfig.get().pluginId)
}

kotlin {
    androidTarget()

    jvm("desktop")

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
            export(libs.calfAdaptiveUi)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.animation)
                implementation(compose.materialIconsExtended)

                api(libs.bundles.multiplatformLibs)
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.bundles.androidLibs)
                implementation(libs.ktorClientAndroid)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktorClientDarwin)
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                implementation(libs.ktorClientCio)
            }
        }
    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "me.inassar.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
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


buildkonfig {
    packageName = libs.versions.applicationId.get()
    objectName = "TemplateConfig" // You can name the config file what you want
    val baseUrl = "BASE_URL"
    val flavor = "FLAVOR"

    defaultConfigs {
        when (project.findProperty("buildFlavor")) {
            BuildFlavors.DEV.name -> {
                buildConfigField(
                    type = STRING,
                    name = flavor,
                    value = BuildFlavors.DEV.name,
                    const = true
                )
                buildConfigField(
                    type = STRING,
                    name = baseUrl,
                    value = "https://dummyjson.com/",
                    const = true
                )
            }

            BuildFlavors.QA.name -> {
                buildConfigField(
                    type = STRING,
                    name = flavor,
                    value = BuildFlavors.QA.name,
                    const = true
                )
                buildConfigField(
                    type = STRING,
                    name = baseUrl,
                    value = "https://dummyjson.com/",
                    const = true
                )
            }

            BuildFlavors.STG.name -> {
                buildConfigField(
                    type = STRING,
                    name = flavor,
                    value = BuildFlavors.STG.name,
                    const = true
                )
                buildConfigField(
                    type = STRING,
                    name = baseUrl,
                    value = "https://dummyjson.com/",
                    const = true
                )
            }

            BuildFlavors.PROD.name -> {
                buildConfigField(
                    type = STRING,
                    name = flavor,
                    value = BuildFlavors.PROD.name,
                    const = true
                )
                buildConfigField(
                    type = STRING,
                    name = baseUrl,
                    value = "https://dummyjson.com/",
                    const = true
                )
            }
        }
    }
}