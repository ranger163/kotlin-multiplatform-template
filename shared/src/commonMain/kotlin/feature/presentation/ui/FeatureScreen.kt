package feature.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import feature.presentation.manipulator.FeatureEvents
import feature.presentation.manipulator.FeatureViewModel

/**
 * Created by Ahmed Nassar on 5/27/23.
 */

@Composable
fun ProductsScreen() {
    val viewModel: FeatureViewModel = getViewModel(key = Unit,
        factory = viewModelFactory { FeatureViewModel() })
    val productsState = viewModel.productsState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.onEvent(FeatureEvents.GetProducts)
    }

    ProductsList(productsState)
}
