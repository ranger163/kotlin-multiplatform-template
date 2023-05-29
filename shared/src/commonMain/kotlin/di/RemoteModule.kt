package di

import feature.data.remote.FeatureRemoteApi
import feature.data.remote.source.FeatureRemoteApiImpl
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
val remoteModule = module {
    single<FeatureRemoteApi> { FeatureRemoteApiImpl(get()) }
}