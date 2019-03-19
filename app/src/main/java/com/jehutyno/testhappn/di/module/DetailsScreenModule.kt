package com.jehutyno.testhappn.di.module

import com.jehutyno.data.articles.ArticlesRepository
import com.jehutyno.testhappn.di.scope.DetailsScreenScope
import com.jehutyno.testhappn.ui.details.DetailsFragment
import com.jehutyno.testhappn.ui.details.DetailsPresenter
import com.jehutyno.usecases.AddFavorite
import com.jehutyno.usecases.GetArticle
import com.jehutyno.usecases.RemoveFavorite
import dagger.Module
import dagger.Provides

@Module
class DetailsScreenModule(val detailsFragment: DetailsFragment) {

    @Provides
    @DetailsScreenScope
    fun provideDetailsFragment() = detailsFragment

    @Provides
    @DetailsScreenScope
    fun provideDetailsPresenter(
        detailsView: DetailsFragment,
        getArticle: GetArticle,
        addFavorite: AddFavorite,
        removeFavorite: RemoveFavorite
        ) = DetailsPresenter(detailsView, getArticle, addFavorite, removeFavorite)

    @Provides
    @DetailsScreenScope
    fun provideGetArticle(articlesRepository: ArticlesRepository): GetArticle {
        return GetArticle(articlesRepository)
    }

}