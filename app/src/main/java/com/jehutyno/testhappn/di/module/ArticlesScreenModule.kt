package com.jehutyno.testhappn.di.module

import com.jehutyno.data.articles.ArticlesRepository
import com.jehutyno.testhappn.di.scope.ArticlesScreenScope
import com.jehutyno.testhappn.ui.articles.ArticlesFragment
import com.jehutyno.testhappn.ui.articles.ArticlesPresenter
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
        articlesView: ArticlesFragment,
        getArticles: GetArticles,
        requestNewArticles: RequestNewArticles
    ) = ArticlesPresenter(articlesView, getArticles, requestNewArticles)

    @Provides
    @ArticlesScreenScope
    fun provideGetArticles(articlesRepository: ArticlesRepository): GetArticles {
        return GetArticles(articlesRepository)
    }

    @Provides
    @ArticlesScreenScope
    fun provideRequestNewArticles(articlesRepository: ArticlesRepository): RequestNewArticles {
        return RequestNewArticles(articlesRepository)
    }

}