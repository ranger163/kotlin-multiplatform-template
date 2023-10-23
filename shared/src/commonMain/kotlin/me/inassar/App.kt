package me.inassar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.ScaleTransition
import cafe.adriel.voyager.transitions.SlideTransition
import me.inassar.common.composable.TopBar
import me.inassar.common.config.Platform
import me.inassar.features.feature.presentation.ui.products.ProductsScreen
import me.inassar.platform.currentPlatform

@Composable
fun App() {
    MaterialTheme {
        Navigator(
            screen = ProductsScreen
        ) { navigator ->
            Scaffold(
                topBar = {
                TopBar(
                    title = navigator.lastItem.key,
                    canPop = navigator.canPop,
                    appBarColor = Color.Red,
                    statusBarColor = Color.Red,
                    onNavigationBackClick = { navigator.pop() })
            }
            ) { paddingValues ->
                when (currentPlatform) {
                    Platform.IOS -> SlideTransition(
                        navigator = navigator,
                        modifier = Modifier.padding(paddingValues)
                    )

                    Platform.ANDROID -> FadeTransition(
                        navigator = navigator,
                        modifier = Modifier.padding(paddingValues)
                    )

                    Platform.DESKTOP -> ScaleTransition(
                        navigator = navigator,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}
