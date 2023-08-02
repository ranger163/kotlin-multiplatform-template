package me.inassar

import io.ktor.client.engine.darwin.Darwin
import me.inassar.common.config.Platform
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 7/31/23.
 */

actual fun getPlatformName(): Platform = Platform.IOS
actual fun platformNetworkEngineModule() = module {
    single { Darwin.create() }
}