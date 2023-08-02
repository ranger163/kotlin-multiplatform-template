package me.inassar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import me.inassar.features.feature.presentation.ui.ProductsScreen

@Composable
fun App() {
    MaterialTheme {
        Scaffold {
            ProductsScreen()
        }
    }
}