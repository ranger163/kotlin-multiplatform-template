package me.inassar.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import me.inassar.platformModule

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
fun initKoinForAndroid(enableNetworkLogs: Boolean, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            appModule(enableNetworkLogs = enableNetworkLogs),
            platformModule(),
            remoteModule,
            cacheModule,
            repositoryModule,
            viewModelModule
        )
    }

// called by iOS, desktop...etc
fun initKoin(enableNetworkLogs: Boolean) =
    initKoinForAndroid(enableNetworkLogs = enableNetworkLogs) {}