package com.jehutyno.data.favorites

import com.jehutyno.data.articles.PersistenceFavoritesSource
import com.jehutyno.domain.model.AddFavoriteRequest
import com.jehutyno.domain.model.Favorite


class FavoritesRepository(
    private val favoritePersistenceSource: PersistenceFavoritesSource,
    private val networkFavoritesSource: NetworkFavoritesSource
) {

    suspend fun getSavedFavorite(favoriteId: String) = favoritePersistenceSource.getPersistedFavorite(favoriteId)

    suspend fun getSavedFavorites() = favoritePersistenceSource.getPersistedFavorites()

    @Throws(Exception::class)
    suspend fun requestNewFavorites(): List<Favorite>? {
        val newFavorites = networkFavoritesSource.getNetworkFavorites()
        favoritePersistenceSource.saveFavorites(newFavorites)
        return getSavedFavorites()
    }

    @Throws(Exception::class)
    suspend fun requestAddFavorites(articleId: String): Favorite {
        val response = networkFavoritesSource.addNetworkFavorite(AddFavoriteRequest(articleId))
        favoritePersistenceSource.saveFavorite(articleId, response._id)
        return response
    }

    @Throws(Exception::class)
    suspend fun requestRemoveFavorites(articleId: String, favoriteId: String) {
        val response = networkFavoritesSource.removeNetworkFavorite(favoriteId)
        favoritePersistenceSource.deleteFavorite(articleId, favoriteId)
        return response
    }



}