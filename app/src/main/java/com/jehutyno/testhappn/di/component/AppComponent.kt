package com.jehutyno.testhappn.di.component

import com.jehutyno.testhappn.TestHappnApp
import com.jehutyno.testhappn.di.module.AppModule
import com.jehutyno.testhappn.di.module.ArticlesModule
import com.jehutyno.testhappn.di.module.DatabaseModule
import com.jehutyno.testhappn.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    fun plus(articlesModule: ArticlesModule): ArticlesComponent
    fun inject(app: TestHappnApp)
}