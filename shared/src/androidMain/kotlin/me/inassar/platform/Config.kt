package me.inassar.platform

import io.ktor.client.engine.android.Android
import me.inassar.common.config.Platform
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 7/31/23.
 */

actual fun getPlatformName(): Platform = Platform.ANDROID
actual fun platformNetworkEngineModule() = module {
    single { Android.create() }
}