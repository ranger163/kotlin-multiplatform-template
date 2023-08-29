import Dependencies.ThirdParty.kamelImageLoader

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

        val libs = ktor + kotlinX + ThirdParty.thirdPartyLibs
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val appcompat =
            "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val composeActivity =
            "androidx.activity:activity-compose:${Versions.activityCompose}"
        private const val runtime =
            "org.jetbrains.compose.runtime:runtime:${Versions.composeMultiplatformVersion}"

        const val composeUI = "androidx.compose.ui:ui:${Versions.composeMultiplatformVersion}"
        const val composeUtil =
            "androidx.compose.ui:ui-util:${Versions.composeMultiplatformVersion}"
        const val composeTooling =
            "androidx.compose.ui:ui-tooling-preview:${Versions.composeMultiplatformVersion}"
        const val composeMaterialIcons =
            "androidx.compose.material:material-icons-extended:${Versions.composeMultiplatformVersion}"

        val libs = arrayListOf<String>().apply {
            add(composeActivity)
            add(appcompat)
            add(coreKtx)
            add(composeMaterialIcons)
            add(runtime)
            add(composeUI)
            add(composeUtil)
            add(composeTooling)
        }
    }

    object IOS {

    }

    object Desktop {

    }

    object ThirdParty {
        const val koinCore = "io.insert-koin:koin-core:${Versions.koinVersion}"
        const val test = "io.insert-koin:koin-test:${Versions.koinVersion}"
        const val testJUnit4 = "io.insert-koin:koin-test-junit4:${Versions.koinVersion}"
        const val android = "io.insert-koin:koin-android:${Versions.koinVersion}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koinAndroidXCompose}"

        const val mokoMvvm =
            "dev.icerock.moko:mvvm-compose:${Versions.mokoVersion}" // api mvvm-core, getViewModel for Compose Multiplatfrom
        const val mokoFlow =
            "dev.icerock.moko:mvvm-flow-compose:${Versions.mokoVersion}" // api mvvm-flow, binding extensions for Compose Multiplatfrom

        const val kamelImageLoader = "media.kamel:kamel-image:${Versions.kamelImageLoaderVersion}"


        // Navigator
        private const val voyagerNavigator =
            "cafe.adriel.voyager:voyager-navigator:${Versions.voyagerVersion}"
        private const val voyagerTransitions =
            "cafe.adriel.voyager:voyager-transitions:${Versions.voyagerVersion}"

        val thirdPartyLibs = arrayListOf<String>(
            koinCore,
            mokoMvvm,
            mokoFlow,
            kamelImageLoader,
            voyagerNavigator,
            voyagerTransitions
        )
    }
}