package com.jehutyno.testhappn.framework.favorites

import com.jehutyno.data.articles.NetworkFavoritesSource
import com.jehutyno.domain.model.Favorite
import com.jehutyno.testhappn.network.FavoritesApi

class RetrofitFavoritesNetworkSource(private val favoritesApi: FavoritesApi):
    NetworkFavoritesSource {

    @Throws(Exception::class)
    override suspend fun getNetworkFavorites(): List<Favorite> {
        return favoritesApi.getFavoritesAsync().await()
    }

}