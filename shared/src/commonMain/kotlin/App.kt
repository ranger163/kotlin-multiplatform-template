import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import feature.presentation.ui.ProductsScreen

@Composable
fun App() {
    MaterialTheme {
        Scaffold {
            ProductsScreen()
        }
    }
}