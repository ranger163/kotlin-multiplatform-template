package me.inassar.common.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
@Composable
fun RenderError(message: String) {
    Text(text = message, color = Color.Black)
}