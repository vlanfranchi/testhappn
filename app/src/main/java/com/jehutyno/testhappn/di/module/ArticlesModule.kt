package com.jehutyno.testhappn.di.module

import com.jehutyno.data.ArticlesRepository
import com.jehutyno.testhappn.framework.RetrofitArticlesNetworkSource
import com.jehutyno.testhappn.framework.RoomArticlesPersistenceSource
import com.jehutyno.testhappn.network.ArticlesApi
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {

    @Provides
    fun provideRoomArticlesSource() = RoomArticlesPersistenceSource()

    @Provides
    fun provideRetrofitArticlesSource(articlesApi: ArticlesApi) = RetrofitArticlesNetworkSource(articlesApi)

    @Provides
    fun provideRetrofitArticlesRepository(articlesPersistenceSource: RoomArticlesPersistenceSource, retrofitArticlesNetworkSource: RetrofitArticlesNetworkSource)
            = ArticlesRepository(articlesPersistenceSource, retrofitArticlesNetworkSource)

}