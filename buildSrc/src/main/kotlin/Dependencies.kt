/**
 * Created by Ahmed Nassar on 5/22/23.
 */
class Dependencies {

    object Multiplatform {
        private const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktorVersion}"
        private const val contentNegotiation =
            "io.ktor:ktor-client-content-negotiation:${Versions.ktorVersion}"
        private const val ktorLogging = "io.ktor:ktor-client-logging:${Versions.ktorVersion}"
        private const val ktorSerializationJson =
            "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktorVersion}"
        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktorVersion}"
        const val clientCio = "io.ktor:ktor-client-cio:${Versions.ktorVersion}"
        const val clientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktorVersion}"

        private const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}"
        private const val kotlinDateTime =
            "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"

        const val koin = "io.insert-koin:koin-core:${Versions.koinVersion}"
        const val koinAndroid = "io.insert-koin:koin-androidx-compose${Versions.koinVersion}"

        private const val mokoMvvm =
            "dev.icerock.moko:mvvm-compose:${Versions.mokoVersion}" // api mvvm-core, getViewModel for Compose Multiplatfrom
        private const val mokoFlow =
            "dev.icerock.moko:mvvm-flow-compose:${Versions.mokoVersion}" // api mvvm-flow, binding extensions for Compose Multiplatfrom

        const val kamelImageLoader = "media.kamel:kamel-image:${Versions.kamelImageLoaderVersion}"

        val ktor = arrayListOf<String>().apply {
            add(ktorCore)
            add(contentNegotiation)
            add(ktorLogging)
            add(ktorSerializationJson)
        }

        val kotlinX = arrayListOf<String>().apply {
            add(coroutinesCore)
            add(kotlinDateTime)
        }

        val moko = arrayListOf<String>().apply {
            add(mokoMvvm)
            add(mokoFlow)
        }

        val libs = ktor + kotlinX + koin + moko + kamelImageLoader
    }


    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koinVersion}"
        const val test = "io.insert-koin:koin-test:${Versions.koinVersion}"
        const val testJUnit4 = "io.insert-koin:koin-test-junit4:${Versions.koinVersion}"
        const val android = "io.insert-koin:koin-android:${Versions.koinAndroid}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koinAndroidCompose}"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appcompat =
            "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val composeActivity =
            "androidx.activity:activity-compose:${Versions.activityCompose}"
        private const val runtime =
            "org.jetbrains.compose.runtime:runtime:${Versions.composeVersion}"

        const val composeUI = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val composeUtil = "androidx.compose.ui:ui-util:${Versions.composeVersion}"
        val composeMaterial = "androidx.compose.material:${Versions.composeVersion}"
        const val composeMaterial3 = "androidx.compose.material3:${Versions.composeVersion}"
        const val composeTooling =
            "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
        const val composeMaterialIcons =
            "androidx.compose.material:material-icons-extended:${Versions.composeVersion}"

        val multiplatformLibs = arrayListOf<String>().apply {
            add(composeActivity)
            add(appcompat)
            add(coreKtx)
            add(composeMaterialIcons)
        }
    }

    object IOS {

    }

    object Desktop {

    }

    object ThirdParty {

    }
}