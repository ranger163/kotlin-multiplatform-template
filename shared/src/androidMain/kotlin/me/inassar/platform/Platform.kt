package me.inassar.platform

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import io.ktor.client.engine.android.Android
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
    get() = Platform.ANDROID

actual val platformNetworkEngineModule: Module
    get() = module { single { Android.create() } }

@Composable
actual fun ChangeStatusBarColors(statusBarColor: Color) {
    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = statusBarColor.toArgb()
        WindowCompat.getInsetsController(window, view)
    }
}