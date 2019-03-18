package com.jehutyno.testhappn.di.module

import androidx.room.Dao
import com.jehutyno.data.ArticlesRepository
import com.jehutyno.testhappn.database.ArticleDAO
import com.jehutyno.testhappn.database.ArticlesDatabase
import com.jehutyno.testhappn.framework.RetrofitArticlesNetworkSource
import com.jehutyno.testhappn.framework.RoomArticlesPersistenceSource
import com.jehutyno.testhappn.network.ArticlesApi
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {

    @Provides
    fun provideRoomArticlesSource(articlesDao: ArticleDAO) = RoomArticlesPersistenceSource(articlesDao)

    @Provides
    fun provideRetrofitArticlesSource(articlesApi: ArticlesApi) = RetrofitArticlesNetworkSource(articlesApi)

    @Provides
    fun provideRetrofitArticlesRepository(articlesPersistenceSource: RoomArticlesPersistenceSource, retrofitArticlesNetworkSource: RetrofitArticlesNetworkSource)
            = ArticlesRepository(articlesPersistenceSource, retrofitArticlesNetworkSource)

}