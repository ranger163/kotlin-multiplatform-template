package me.inassar

import android.app.Application
import me.inassar.di.initKoinForAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

/**
 * Created by Ahmed Nassar on 5/27/23.
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() = initKoinForAndroid(
        enableNetworkLogs = true, // Pass true/false depending on debug/release config
        appDeclaration = {
            androidLogger()
            androidContext(this@MyApp)
        }
    )
}