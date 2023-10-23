package me.inassar.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.ktor.client.engine.cio.CIO
import me.inassar.common.config.Platform
import org.koin.core.module.Module
import org.koin.dsl.module
import java.util.Locale

/**
 * Created by Ahmed Nassar on 7/31/23.
 */

actual val currentDeviceLanguage: String
    get() = Locale.getDefault().language

actual val currentPlatform: Platform
    get() = Platform.DESKTOP

actual val platformNetworkEngineModule: Module
    get() = module { single { CIO.create() } }

@Composable
actual fun ChangeStatusBarColors(statusBarColor: Color) = Unit