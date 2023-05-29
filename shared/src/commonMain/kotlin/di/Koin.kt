package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import platformModule

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
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

// called by iOS...etc
fun initKoin(enableNetworkLogs: Boolean = false) =
    initKoin(enableNetworkLogs = enableNetworkLogs) {}