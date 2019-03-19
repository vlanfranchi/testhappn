package com.jehutyno.data.articles

import com.jehutyno.domain.model.AddFavoriteRequest
import com.jehutyno.domain.model.BaseResponse
import com.jehutyno.domain.model.Favorite

interface NetworkFavoritesSource {

    @Throws(Exception::class)
    suspend fun getNetworkFavorites(): List<Favorite>

    @Throws(Exception::class)
    suspend fun addNetworkFavorite(addFavorite: AddFavoriteRequest): BaseResponse

    @Throws(Exception::class)
    suspend fun removeNetworkFavorite(favoriteId: String): BaseResponse

}