package com.jehutyno.data.articles

import com.jehutyno.domain.model.Favorite


interface PersistenceFavoritesSource {

    suspend fun getPersistedFavorite(favoriteId: String): Favorite?
    suspend fun getPersistedFavorites(): List<Favorite>?
    suspend fun saveFavorites(favorites: List<Favorite>?)
    suspend fun saveFavorite(articleId: String, favoriteId: String)
    suspend fun deleteFavorite(articleId: String, favoriteId: String)

}