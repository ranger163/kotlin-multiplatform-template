package me.inassar

import MainView
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    init()

    Window(onCloseRequest = ::exitApplication) {
        MainView()
    }
}

private fun init() {
    koin
}