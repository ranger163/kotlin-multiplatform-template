package me.inassar.di

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import me.inassar.common.network.ktorHttpClient
import org.koin.dsl.module

/**
 * Created by Ahmed Nassar on 5/27/23.
 */

fun appModule(enableNetworkLogs: Boolean) = module {
    Napier.base(DebugAntilog())
    single { ktorHttpClient(get(), enableNetworkLogs = enableNetworkLogs) }
    single { CoroutineScope(Dispatchers.Default + SupervisorJob()) }
}