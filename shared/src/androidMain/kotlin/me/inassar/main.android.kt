import androidx.compose.runtime.Composable
import me.inassar.common.config.Platform
import io.ktor.client.engine.android.Android
import org.koin.dsl.module

actual fun getPlatformName(): Platform = Platform.ANDROID
actual fun platformModule() = module {
    single { Android.create() }
}

@Composable
fun MainView() = App()
