package me.inassar.di

import me.inassar.features.feature.data.repository.FeatureRepositoryImpl
import me.inassar.features.feature.domain.repository.FeatureRepository
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
val repositoryModule = module {
    single<FeatureRepository> { FeatureRepositoryImpl() }
}