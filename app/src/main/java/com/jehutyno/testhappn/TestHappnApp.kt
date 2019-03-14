package com.jehutyno.testhappn

import android.app.Application
import com.jehutyno.testhappn.di.component.AppComponent
import com.jehutyno.testhappn.di.component.DaggerAppComponent
import com.jehutyno.testhappn.di.module.AppModule

class TestHappnApp: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

}