import androidx.compose.runtime.Composable
import io.ktor.client.engine.cio.CIO
import me.inassar.common.config.Platform
import org.koin.dsl.module

actual fun getPlatformName(): Platform = Platform.DESKTOP
actual fun platformModule() = module {
    single { CIO.create() }
}

@Composable
fun MainView() = App()