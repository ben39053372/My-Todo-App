package com.ben39053372.myandroidtemplate

import android.app.Application
import timber.log.Timber
import com.ben39053372.myandroidtemplate.utils.MyLogTree

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initLogger()

    }

    fun initLogger() {
        // init timber
        if (BuildConfig.DEBUG) {
            Timber.plant(MyLogTree)
        }
    }
}