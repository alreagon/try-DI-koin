package com.example.c7_koin

import android.app.Application
import com.example.c7_koin.di.appModule
import com.example.c7_koin.di.repositoryModule
import com.example.c7_koin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        GlobalContext.startKoin {
            // declare used Android context
            androidContext(this@MyApp)
            // declare modules
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }

}