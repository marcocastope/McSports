package com.marcocastope.mcsports.android

import android.app.Application
import com.marcocastope.mcsports.android.di.appModule
import com.marcocastope.mcsports.di.getSharedModules
import org.koin.core.context.startKoin

class SportsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}