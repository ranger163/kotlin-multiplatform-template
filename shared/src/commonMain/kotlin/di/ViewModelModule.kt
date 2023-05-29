package di

import feature.presentation.manipulator.FeatureViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
val viewModelModule = module {
    singleOf(::FeatureViewModel)
}