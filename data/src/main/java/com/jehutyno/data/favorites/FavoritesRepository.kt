package com.jehutyno.data.articles

import com.jehutyno.data.favorites.NetworkFavoritesSource
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
    suspend fun requestAddFavorites(favoriteId: String): Favorite {
        val response = networkFavoritesSource.addNetworkFavorite(AddFavoriteRequest(favoriteId))
        favoritePersistenceSource.saveFavorite(Favorite(favoriteId))
        return response
    }

    @Throws(Exception::class)
    suspend fun requestRemoveFavorites(favoriteId: String) {
        val response = networkFavoritesSource.removeNetworkFavorite(favoriteId)
        favoritePersistenceSource.deleteFavorite(Favorite(favoriteId))
        return response
    }



}