package com.jehutyno.data.articles

import com.jehutyno.domain.model.Favorite


interface PersistenceFavoritesSource {

    suspend fun getPersistedFavorite(favoriteId: String): Favorite?
    suspend fun getPersistedFavorites(): List<Favorite>?
    suspend fun saveFavorites(favorites: List<Favorite>?)

}