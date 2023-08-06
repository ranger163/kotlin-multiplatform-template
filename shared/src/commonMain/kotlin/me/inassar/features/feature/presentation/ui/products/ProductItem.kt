package me.inassar.features.feature.presentation.ui.products

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import me.inassar.common.composable.LoadImage
import me.inassar.features.feature.presentation.data.UiProduct

/**
 * Created by Ahmed Nassar on 5/27/23.
 */

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: UiProduct,
    onItemClicked: () -> Unit
) {
    var isCardExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onItemClicked() })
    {
        Column(modifier = modifier.fillMaxWidth()) {
            LoadImage(
                modifier = modifier.height(150.dp).fillMaxWidth(),
                imagePath = product.thumbnail,
                contentDescription = product.title,
                contentScale = ContentScale.FillBounds
            )

            Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        maxLines = 1,
                        text = product.title,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleMedium,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        maxLines = 1,
                        text = "${product.price} $",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Divider(
                    modifier.padding(vertical = 4.dp),
                    thickness = 0.5.dp,
                    color = Color.Gray.copy(alpha = 0.3f)
                )

                Text(
                    modifier = modifier.animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    ).clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        isCardExpanded = isCardExpanded.not()
                    }.padding(vertical = 8.dp),
                    text = product.description,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isCardExpanded.not()) 2 else 10,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
    Spacer(modifier = modifier.height(16.dp))
}