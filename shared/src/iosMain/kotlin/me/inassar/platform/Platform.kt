package me.inassar.platform

import io.ktor.client.engine.darwin.Darwin
import me.inassar.common.config.Platform
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSLocale
import platform.Foundation.preferredLanguages

/**
 * Created by Ahmed Nassar on 7/31/23.
 */

actual val currentDeviceLanguage: String
    get() = NSLocale.preferredLanguages.first().toString().substring(0..1)

actual val currentPlatform: Platform
    get() = Platform.IOS

actual val platformNetworkEngineModule: Module
    get() = module { single { Darwin.create() } }