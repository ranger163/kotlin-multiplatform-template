package me.inassar.features.feature.presentation.ui.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import me.inassar.common.component.RenderError
import me.inassar.common.component.RenderLoading
import me.inassar.features.feature.presentation.data.FeatureStrings
import me.inassar.features.feature.presentation.data.UiProducts
import me.inassar.features.feature.presentation.manipulator.FeatureEvents
import me.inassar.features.feature.presentation.manipulator.FeatureState
import me.inassar.features.feature.presentation.manipulator.FeatureViewModel
import me.inassar.features.feature.presentation.ui.details.ProductDetails

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
object ProductsScreen : Screen {

    override val key: ScreenKey = FeatureStrings.PRODUCT_LIST_SCREEN_TITLE.localize()

    @Composable
    override fun Content() {

        val viewModel: FeatureViewModel = getViewModel(key = Unit,
            factory = viewModelFactory { FeatureViewModel() })
        val productsState = viewModel.productsState.collectAsState().value

        LaunchedEffect(Unit) {
            viewModel.onEvent(FeatureEvents.GetProducts)
        }

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

        LazyColumn(
            state = rememberLazyListState(),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(items = data.products, key = { it.hashCode() }) { product ->
                ProductItem(product = product, onItemClicked = {
                    navigator.push(ProductDetails(product))
                })
            }
        }
    }
}
