package me.inassar.platform

import me.inassar.common.config.Platform
import org.koin.core.module.Module

expect val currentDeviceLanguage: String
expect fun getPlatformName(): Platform
expect fun platformNetworkEngineModule(): Module