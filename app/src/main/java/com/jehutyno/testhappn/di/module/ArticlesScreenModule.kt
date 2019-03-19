package com.jehutyno.testhappn.di.module

import com.jehutyno.data.articles.ArticlesRepository
import com.jehutyno.data.articles.FavoritesRepository
import com.jehutyno.testhappn.di.scope.ArticlesScreenScope
import com.jehutyno.testhappn.ui.articles.ArticlesFragment
import com.jehutyno.testhappn.ui.articles.ArticlesPresenter
import com.jehutyno.usecases.AddFavorite
import com.jehutyno.usecases.GetArticles
import com.jehutyno.usecases.RemoveFavorite
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
        requestNewArticles: RequestNewArticles,
        addFavorite: AddFavorite,
        removeFavorite: RemoveFavorite
    ) = ArticlesPresenter(articlesView, getArticles, requestNewArticles, addFavorite, removeFavorite)

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

    @Provides
    @ArticlesScreenScope
    fun provideAddFavorite(favoritesRepository: FavoritesRepository): AddFavorite {
        return AddFavorite(favoritesRepository)
    }

    @Provides
    @ArticlesScreenScope
    fun provideRemoveFavorite(favoritesRepository: FavoritesRepository): RemoveFavorite {
        return RemoveFavorite(favoritesRepository)
    }

}