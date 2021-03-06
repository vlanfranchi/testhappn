package com.jehutyno.testhappn.di.module

import com.jehutyno.data.articles.ArticlesRepository
import com.jehutyno.data.favorites.FavoritesRepository
import com.jehutyno.testhappn.database.articles.ArticleDAO
import com.jehutyno.testhappn.database.favorites.FavoriteDAO
import com.jehutyno.testhappn.framework.articles.RetrofitArticlesNetworkSource
import com.jehutyno.testhappn.framework.articles.RoomArticlesPersistenceSource
import com.jehutyno.testhappn.framework.favorites.RetrofitFavoritesNetworkSource
import com.jehutyno.testhappn.framework.favorites.RoomFavoritesPersistenceSource
import com.jehutyno.testhappn.network.ArticlesApi
import com.jehutyno.testhappn.network.FavoritesApi
import com.jehutyno.usecases.AddFavorite
import com.jehutyno.usecases.RemoveFavorite
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

    @Provides
    fun provideRoomFavoritesSource(favoriteDAO: FavoriteDAO, articlesDao: ArticleDAO) =
        RoomFavoritesPersistenceSource(favoriteDAO, articlesDao)

    @Provides
    fun provideRetrofitFavoritesSource(favoritesApi: FavoritesApi) =
        RetrofitFavoritesNetworkSource(favoritesApi)

    @Provides
    fun provideRetrofitFavoritesRepository(favoritesPersistenceSource: RoomFavoritesPersistenceSource, favoritesNetworkSource: RetrofitFavoritesNetworkSource)
            = FavoritesRepository(favoritesPersistenceSource, favoritesNetworkSource)

    @Provides
    fun provideAddFavorite(favoritesRepository: FavoritesRepository): AddFavorite {
        return AddFavorite(favoritesRepository)
    }

    @Provides
    fun provideRemoveFavorite(favoritesRepository: FavoritesRepository): RemoveFavorite {
        return RemoveFavorite(favoritesRepository)
    }

}