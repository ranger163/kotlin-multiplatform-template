package me.inassar

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
            Scaffold(topBar = {
                TopBar(
                    title = navigator.lastItem.key,
                    canPop = navigator.canPop,
                    onNavigationBackClick = { navigator.pop() })
            }) {
                when (currentPlatform) {
                    Platform.IOS -> SlideTransition(navigator)
                    Platform.ANDROID -> FadeTransition(navigator)
                    Platform.DESKTOP -> ScaleTransition(navigator)
                }
            }
        }
    }
}
