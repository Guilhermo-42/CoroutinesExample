package com.guiherme.coroutines

import android.app.Application
import com.guiherme.coroutines.di.networkModule
import com.guiherme.coroutines.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModule,
                    networkModule
                )
            )
        }
    }

}