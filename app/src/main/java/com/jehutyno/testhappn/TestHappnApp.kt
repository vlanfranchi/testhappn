package com.jehutyno.testhappn

import android.app.Application
import com.jehutyno.testhappn.di.component.AppComponent
import com.jehutyno.testhappn.di.component.ArticlesComponent
import com.jehutyno.testhappn.di.component.DaggerAppComponent
import com.jehutyno.testhappn.di.module.AppModule
import com.jehutyno.testhappn.di.module.ArticlesModule

class TestHappnApp: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    val articlesComponent: ArticlesComponent by lazy { appComponent.plus(ArticlesModule()) }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

}