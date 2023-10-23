package me.inassar.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import me.inassar.common.config.Platform
import org.koin.core.module.Module

expect val currentDeviceLanguage: String
expect val currentPlatform: Platform
expect val platformNetworkEngineModule: Module
@Composable
expect fun ChangeStatusBarColors(statusBarColor: Color)