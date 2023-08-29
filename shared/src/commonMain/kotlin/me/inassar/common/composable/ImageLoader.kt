package me.inassar.common.composable

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import me.inassar.common.locale.GeneralStrings

/**
 * Created by Ahmed Nassar on 7/28/23.
 */

@Composable
fun LoadImage(
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    imagePath: String,
    contentDescription: String?
) {
    KamelImage(
        modifier = modifier,
        contentScale = contentScale,
        resource = asyncPainterResource(imagePath),
        contentDescription = contentDescription,
        animationSpec = tween(),
        onLoading = { loadingProgress ->
            Box(
                modifier = modifier,
                contentAlignment = Alignment.BottomCenter
            ) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth().height(1.dp),
                    progress = loadingProgress
                )
            }
        },
        onFailure = { exception ->
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    imageVector = Icons.Default.BrokenImage,
                    contentDescription =
                    GeneralStrings.UI.IMAGE_CONTENT_DESC_WITH_ERROR.localize(exception),
                    alpha = 0.3f
                )
            }
        }
    )
}