package com.jehutyno.testhappn.framework.favorites

import com.jehutyno.data.favorites.NetworkFavoritesSource
import com.jehutyno.domain.model.AddFavoriteRequest
import com.jehutyno.domain.model.Favorite
import com.jehutyno.testhappn.network.FavoritesApi

class RetrofitFavoritesNetworkSource(private val favoritesApi: FavoritesApi) :
    NetworkFavoritesSource {

    @Throws(Throwable::class)
    override suspend fun addNetworkFavorite(addFavorite: AddFavoriteRequest): Favorite {
        return favoritesApi.addFavoriteAsync(addFavorite).await()
    }

    @Throws(Throwable::class)
    override suspend fun removeNetworkFavorite(favoriteId: String) {
        favoritesApi.removeFavoriteAsync(favoriteId).await()
    }

    @Throws(Throwable::class)
    override suspend fun getNetworkFavorites(): List<Favorite> {
        return favoritesApi.getFavoritesAsync().await()
    }

}