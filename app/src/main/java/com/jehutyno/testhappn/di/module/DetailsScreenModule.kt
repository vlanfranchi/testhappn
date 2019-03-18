package com.jehutyno.testhappn.di.module

import com.jehutyno.data.ArticlesRepository
import com.jehutyno.testhappn.di.scope.DetailsScreenScope
import com.jehutyno.testhappn.ui.details.DetailsFragment
import com.jehutyno.testhappn.ui.details.DetailsPresenter
import com.jehutyno.usecases.GetArticle
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
        getArticle: GetArticle
        ) = DetailsPresenter(detailsView, getArticle)

    @Provides
    @DetailsScreenScope
    fun provideGetArticle(articlesRepository: ArticlesRepository): GetArticle {
        return GetArticle(articlesRepository)
    }

}