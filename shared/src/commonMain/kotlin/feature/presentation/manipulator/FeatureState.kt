package feature.presentation.manipulator

import feature.presentation.data.UiProducts

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
sealed interface FeatureState {
    object Loading : FeatureState
    data class Error(val errorMessage: String) : FeatureState
    data class Success(val uiProducts: UiProducts) : FeatureState
}