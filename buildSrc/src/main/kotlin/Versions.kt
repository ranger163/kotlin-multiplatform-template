import org.gradle.api.JavaVersion

/**
 * Created by Ahmed Nassar on 5/22/23.
 */
object Versions {

    // Global
    const val kotlinVersion = "1.8.20"
    const val agpVersion = "8.0.1"
    const val applicationId = "me.inassar"
    const val jdkVersion = 17
    val javaVersion = JavaVersion.VERSION_17

    // Android
    const val compileSdk = 33
    const val targetSdk = 33
    const val minSdk = 24
    const val VersionCode = 1
    const val VersionName = "1.0.0"

    const val activityCompose = "1.7.1"
    const val appcompat = "1.6.1"
    const val coreKtx = "1.10.1"

    //Third Party
    const val coilVersion = "2.4.0"

    // Multiplatform
    const val composeVersion = "1.4.0"
    const val ktorVersion = "2.3.0"
    const val kotlinxCore = "1.7.1"
    const val kotlinxCoroutines = "1.6.4"
    const val kotlinxDateTime = "0.4.0"
    const val koinVersion = "3.4.0"
    const val koinAndroid = "3.4.0"
    const val koinAndroidCompose = "3.4.4"
    const val mokoVersion = "0.16.1"
}