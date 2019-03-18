package com.jehutyno.testhappn.di.component

import com.jehutyno.testhappn.di.module.ArticlesModule
import com.jehutyno.testhappn.di.module.ArticlesScreenModule
import com.jehutyno.testhappn.di.module.DetailsScreenModule
import com.jehutyno.testhappn.di.scope.ArticlesScope
import dagger.Subcomponent

@ArticlesScope
@Subcomponent(modules = [ArticlesModule::class])
interface ArticlesComponent {
    fun plus(articlesScreenModule: ArticlesScreenModule): ArticlesScreenComponent
    fun plus(detailsScreenModule: DetailsScreenModule): DetailsScreenComponent
}