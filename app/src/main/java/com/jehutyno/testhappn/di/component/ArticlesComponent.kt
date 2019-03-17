package com.jehutyno.testhappn.di.component

import com.jehutyno.testhappn.di.module.ArticlesModule
import com.jehutyno.testhappn.di.scope.ArticlesScope
import dagger.Subcomponent

@ArticlesScope
@Subcomponent(modules = [ArticlesModule::class])
interface ArticlesComponent {

}