package com.jehutyno.testhappn.di.module

import com.jehutyno.data.articles.ArticlesRepository
import com.jehutyno.testhappn.database.articles.ArticleDAO
import com.jehutyno.testhappn.framework.articles.RetrofitArticlesNetworkSource
import com.jehutyno.testhappn.framework.articles.RoomArticlesPersistenceSource
import com.jehutyno.testhappn.network.ArticlesApi
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {

    @Provides
    fun provideRoomArticlesSource(articlesDao: ArticleDAO) =
        RoomArticlesPersistenceSource(articlesDao)

    @Provides
    fun provideRetrofitArticlesSource(articlesApi: ArticlesApi) =
        RetrofitArticlesNetworkSource(articlesApi)

    @Provides
    fun provideRetrofitArticlesRepository(articlesPersistenceSource: RoomArticlesPersistenceSource, retrofitArticlesNetworkSource: RetrofitArticlesNetworkSource)
            = ArticlesRepository(articlesPersistenceSource, retrofitArticlesNetworkSource)

}