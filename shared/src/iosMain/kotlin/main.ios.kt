import androidx.compose.ui.window.ComposeUIViewController
import common.config.Platform
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

actual fun getPlatformName(): Platform = Platform.IOS
actual fun platformModule() = module {
    single { Darwin.create() }
}

fun MainViewController() = ComposeUIViewController { App() }