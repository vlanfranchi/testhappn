package com.jehutyno.testhappn.di.component

import com.jehutyno.testhappn.di.module.ArticlesScreenModule
import com.jehutyno.testhappn.di.scope.ArticlesScreenScope
import com.jehutyno.testhappn.ui.articles.ArticlesFragment
import dagger.Subcomponent

@Subcomponent(modules = [ArticlesScreenModule::class])
@ArticlesScreenScope
interface ArticlesScreenComponent {
    fun inject(fragment: ArticlesFragment)
}