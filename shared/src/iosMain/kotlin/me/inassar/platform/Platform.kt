@file:OptIn(ExperimentalForeignApi::class)

package me.inassar.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.mohamedrejeb.calf.ui.utils.toUIColor
import io.ktor.client.engine.darwin.Darwin
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.copy
import me.inassar.common.config.Platform
import me.inassar.utils.getDeviceOrientation
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.CoreGraphics.CGRectMake
import platform.Foundation.NSLocale
import platform.Foundation.preferredLanguages
import platform.UIKit.UIApplication
import platform.UIKit.UIView
import platform.UIKit.UIWindow

/**
 * Created by Ahmed Nassar on 7/31/23.
 */

actual val currentDeviceLanguage: String
    get() = NSLocale.preferredLanguages.first().toString().substring(0..1)

actual val currentPlatform: Platform
    get() = Platform.IOS

actual val platformNetworkEngineModule: Module
    get() = module { single { Darwin.create() } }

/**
 * This solution is a hack, as in devices that has dynamic island "14 pro/pro max, 15 series"
 * it has this weired horizontal line which doesn't belong to status bar or navigation bar.
 * check the forums here: https://developer.apple.com/forums/thread/715417
 * Also check this blog to know more about this issue explaining: https://useyourloaf.com/blog/iphone-14-screen-sizes/
 */
@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun ChangeStatusBarColors(statusBarColor: Color) {
    val safeFrameSize = remember { mutableStateOf(0.0) }

    val window =
        (UIApplication.sharedApplication.windows.first() as UIWindow)
    // Getting safe area size
    window.safeAreaLayoutGuide.layoutFrame.copy {
        // Getting safe area size in case of landscape and portrait
        if (getDeviceOrientation().portrait) {
            safeFrameSize.value = origin.y
        } else {
            safeFrameSize.value = origin.x
        }
    }

    val statusBar = UIView(
        frame = CGRectMake(
            x = 0.0,
            y = 0.0,
            width = Double.MAX_VALUE,
            height = safeFrameSize.value
        )
    )

    statusBar.backgroundColor = statusBarColor.toUIColor()
    SideEffect {
        UIApplication.sharedApplication.keyWindow?.addSubview(statusBar)
    }
}