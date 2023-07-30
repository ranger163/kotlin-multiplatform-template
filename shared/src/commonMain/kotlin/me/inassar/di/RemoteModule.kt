package me.inassar.di

import me.inassar.feature.data.remote.FeatureRemoteApi
import me.inassar.feature.data.remote.source.FeatureRemoteApiImpl
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
val remoteModule = module {
    single<FeatureRemoteApi> { FeatureRemoteApiImpl(get()) }
}