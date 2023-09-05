import org.gradle.api.JavaVersion

/**
 * Created by Ahmed Nassar on 5/22/23.
 */
object Versions {

    // Global
    const val kotlinVersion = "1.9.0"
    const val agpVersion = "8.1.0"
    const val applicationId = "me.inassar"
    const val jdkVersion = 17
    val javaVersion = JavaVersion.VERSION_17

    // Android
    const val compileSdk = 33
    const val targetSdk = 33
    const val minSdk = 24
    const val VersionCode = 1
    const val VersionName = "1.0.0"
    const val composeCompiler = "1.5.0"

    const val activityCompose = "1.7.2"
    const val appcompat = "1.6.1"
    const val coreKtx = "1.10.1"

    //Third Party
    const val mokoVersion = "0.16.1"
    const val kamelImageLoaderVersion = "0.6.0"
    const val voyagerVersion = "1.0.0-rc07"
    const val calfAdaptiveUiVersion="0.1.1"

    // Multiplatform
    const val composeMultiplatformVersion = "1.5.0-beta01"
    const val ktorVersion = "2.3.3"
    const val kotlinxCoroutines = "1.7.3"
    const val kotlinxDateTime = "0.4.0"
    const val koinVersion = "3.4.3"
    const val koinAndroidXCompose = "3.4.6"
}