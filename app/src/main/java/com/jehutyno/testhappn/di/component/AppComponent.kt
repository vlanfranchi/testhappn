package com.jehutyno.testhappn.di.component

import com.jehutyno.testhappn.TestHappnApp
import com.jehutyno.testhappn.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: TestHappnApp)
}