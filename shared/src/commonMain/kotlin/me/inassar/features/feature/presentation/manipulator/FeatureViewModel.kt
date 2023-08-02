package me.inassar.features.feature.presentation.manipulator

import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.inassar.common.network.ResponseResource
import me.inassar.features.feature.domain.repository.FeatureRepository
import me.inassar.features.feature.presentation.mapper.toUiProducts
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
class FeatureViewModel : ViewModel(), KoinComponent {
    private val repository: FeatureRepository by inject()


    private val _productsState: MutableStateFlow<FeatureState> = MutableStateFlow(FeatureState.Loading)
    val productsState: CStateFlow<FeatureState> = _productsState.cStateFlow()

    fun onEvent(events: FeatureEvents) {
        when (events) {
            FeatureEvents.GetProducts -> getFeatures()
        }
    }

    private fun getFeatures() {
        // We should specify dispatchers to be on default always, as this is the only dispatcher that supports desktop
        viewModelScope.launch(Dispatchers.Default) {
            repository.getProducts().collect { result ->
                when (result) {
                    is ResponseResource.Error ->
                        _productsState.update {
                            FeatureState.Error(result.error.message.orEmpty())
                        }

                    is ResponseResource.Success -> _productsState.update {
                        FeatureState.Success(result.data.toUiProducts())
                    }
                }
            }
        }
    }
}
