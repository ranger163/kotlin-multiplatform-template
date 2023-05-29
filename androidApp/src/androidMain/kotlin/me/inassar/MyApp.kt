package me.inassar

import android.app.Application
import di.appModule
import di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(appModule(enableNetworkLogs = true))
        }
    }
}