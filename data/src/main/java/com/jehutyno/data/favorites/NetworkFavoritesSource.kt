package com.jehutyno.data.articles

import com.jehutyno.domain.model.Favorite

interface NetworkFavoritesSource {

    @Throws(Exception::class)
    suspend fun getNetworkFavorites(): List<Favorite>

}