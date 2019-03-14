package com.jehutyno.testhappn.di.module

import com.jehutyno.testhappn.TestHappnApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: TestHappnApp) {
    @Provides
    @Singleton
    fun provideApp() = app
}