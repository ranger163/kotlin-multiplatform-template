package di

import common.network.ktorHttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 5/27/23.
 */

fun appModule(enableNetworkLogs: Boolean) = module {
    single { ktorHttpClient(get(), enableNetworkLogs = enableNetworkLogs) }
    single { CoroutineScope(Dispatchers.Default + SupervisorJob()) }
}