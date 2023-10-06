package me.inassar.features.feature.presentation.ui.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import me.inassar.common.composable.RenderError
import me.inassar.common.composable.RenderLoading
import me.inassar.features.feature.presentation.data.FeatureStrings
import me.inassar.features.feature.presentation.data.UiProducts
import me.inassar.features.feature.presentation.manipulator.FeatureEvents
import me.inassar.features.feature.presentation.manipulator.FeatureModel
import me.inassar.features.feature.presentation.manipulator.FeatureState
import me.inassar.features.feature.presentation.ui.details.ProductDetails
import org.koin.core.component.KoinComponent

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
object ProductsScreen : Screen, KoinComponent {

    override val key: ScreenKey = FeatureStrings.PRODUCT_LIST_SCREEN_TITLE.localize()

    @Composable
    override fun Content() {

        val featureModel = rememberScreenModel { FeatureModel() }
        val productsState by featureModel.state.collectAsState()

        LifecycleEffect(onStarted = { featureModel.onEvent(FeatureEvents.GetProducts) })

        ProductsList(productsState)
    }

    @Composable
    fun ProductsList(state: FeatureState) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (state) {
                is FeatureState.Loading -> RenderLoading()
                is FeatureState.Error -> RenderError(message = state.errorMessage)
                is FeatureState.Success -> RenderData(state.uiProducts)
            }
        }
    }

    @Composable
    fun RenderData(data: UiProducts) {
        val navigator = LocalNavigator.currentOrThrow

        LazyVerticalGrid(
            columns = GridCells.Adaptive(200.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(items = data.products, key = { it.hashCode() }) { product ->
                ProductItem(product = product, onItemClicked = {
                    navigator.push(ProductDetails(product))
                })
            }
        }
    }
}
