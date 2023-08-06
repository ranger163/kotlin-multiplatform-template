package me.inassar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import me.inassar.common.composable.TopBar
import me.inassar.features.feature.presentation.ui.products.ProductsScreen

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
                CurrentScreen()
            }
        }
    }
}