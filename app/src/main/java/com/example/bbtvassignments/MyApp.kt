package com.example.bbtvassignments

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// MyApp.kt
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
//            modules(appModule)
        }
    }
}
