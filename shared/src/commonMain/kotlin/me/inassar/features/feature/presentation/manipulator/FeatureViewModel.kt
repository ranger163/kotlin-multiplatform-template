package me.inassar.features.feature.presentation.manipulator

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.Dispatchers
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
class FeatureModel : StateScreenModel<FeatureState>(initialState = FeatureState.Loading), KoinComponent {
    private val repository: FeatureRepository by inject()

    fun onEvent(events: FeatureEvents) {
        when (events) {
            FeatureEvents.GetProducts -> getFeatures()
        }
    }

    private fun getFeatures() {
        // We should specify dispatchers to be on default always, as this is the only dispatcher that supports desktop
        coroutineScope.launch(Dispatchers.Default) {
            repository.getProducts().collect { result ->
                when (result) {
                    is ResponseResource.Error ->
                        mutableState.update {
                            FeatureState.Error(result.error.message.orEmpty())
                        }

                    is ResponseResource.Success -> mutableState.update {
                        FeatureState.Success(result.data.toUiProducts())
                    }
                }
            }
        }
    }
}
