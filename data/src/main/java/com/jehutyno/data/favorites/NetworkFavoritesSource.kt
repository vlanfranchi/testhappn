package com.jehutyno.data.favorites

import com.jehutyno.domain.model.AddFavoriteRequest
import com.jehutyno.domain.model.Favorite

interface NetworkFavoritesSource {

    @Throws(Exception::class)
    suspend fun getNetworkFavorites(): List<Favorite>

    @Throws(Exception::class)
    suspend fun addNetworkFavorite(addFavorite: AddFavoriteRequest): Favorite

    @Throws(Exception::class)
    suspend fun removeNetworkFavorite(favoriteId: String)

}