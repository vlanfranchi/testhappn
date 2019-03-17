package com.jehutyno.testhappn.di.module

import com.jehutyno.data.ArticlesRepository
import com.jehutyno.testhappn.di.scope.ArticlesScreenScope
import com.jehutyno.testhappn.ui.articles.ArticlesFragment
import com.jehutyno.testhappn.ui.articles.ArticlesPresenter
import com.jehutyno.testhappn.ui.articles.ArticlesView
import com.jehutyno.usecases.GetArticles
import com.jehutyno.usecases.RequestNewArticles
import dagger.Module
import dagger.Provides

@Module
class ArticlesScreenModule(val articlesFragment: ArticlesFragment) {

    @Provides
    @ArticlesScreenScope
    fun provideRoomArticlesFragment() = articlesFragment

    @Provides
    @ArticlesScreenScope
    fun provideArticlesPresenter(
        articlesView: ArticlesView,
        getArticles: GetArticles,
        requestNewArticles: RequestNewArticles
    ) = ArticlesPresenter(articlesView, getArticles, requestNewArticles)

    @Provides
    @ArticlesScreenScope
    fun provideGetTrips(articlesRepository: ArticlesRepository): GetArticles {
        return GetArticles(articlesRepository)
    }

    @Provides
    @ArticlesScreenScope
    fun provideRequestNewTrips(articlesRepository: ArticlesRepository): RequestNewArticles {
        return RequestNewArticles(articlesRepository)
    }

}