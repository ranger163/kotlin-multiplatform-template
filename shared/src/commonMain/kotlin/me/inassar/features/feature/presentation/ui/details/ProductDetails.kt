package me.inassar.features.feature.presentation.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import me.inassar.common.composable.LoadImage
import me.inassar.common.composable.RatingBar
import me.inassar.features.feature.presentation.data.UiProduct

/**
 * Created by Ahmed Nassar on 8/5/23.
 */
class ProductDetails(private val product: UiProduct) : Screen {

    override val key: ScreenKey = product.title

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
            ) {
                LoadImage(
                    modifier = Modifier.fillMaxSize(),
                    imagePath = product.thumbnail,
                    contentDescription = product.title,
                    contentScale = ContentScale.FillBounds
                )
                RatingBar(
                    rating = product.rating,
                    modifier = Modifier.background(
                        color = Color.Gray.copy(alpha = 0.5f),
                        shape = MaterialTheme.shapes.medium.copy(
                            topEnd = CornerSize(0.dp),
                            topStart = CornerSize(8.dp),
                            bottomEnd = CornerSize(0.dp),
                            bottomStart = CornerSize(0.dp)
                        )
                    ).align(Alignment.BottomEnd).padding(4.dp)
                )
            }

            Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(0.9f),
                        maxLines = 1,
                        text = product.title,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleLarge,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        maxLines = 1,
                        text = "${product.price} $",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Divider(
                    Modifier.padding(vertical = 8.dp),
                    thickness = 0.5.dp,
                    color = Color.Gray.copy(alpha = 0.3f)
                )

                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = product.description,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}