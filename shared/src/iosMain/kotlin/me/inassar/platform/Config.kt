package me.inassar.platform

import io.ktor.client.engine.darwin.Darwin
import me.inassar.common.config.Platform
import org.koin.dsl.module
import platform.Foundation.NSLocale
import platform.Foundation.preferredLanguages

/**
 * Created by Ahmed Nassar on 7/31/23.
 */

actual val currentDeviceLanguage: String
    get() = NSLocale.preferredLanguages.first().toString().substring(0..1)

actual fun getPlatformName(): Platform = Platform.IOS
actual fun platformNetworkEngineModule() = module {
    single { Darwin.create() }
}