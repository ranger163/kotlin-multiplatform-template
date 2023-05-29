import androidx.compose.runtime.Composable
import common.config.Platform
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module

actual fun getPlatformName(): Platform = Platform.DESKTOP
actual fun platformModule() = module {
    single { CIO.create() }
}

@Composable
fun MainView() = App()