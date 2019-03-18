package com.jehutyno.data.articles

import com.jehutyno.domain.model.Favorite


class FavoritesRepository(
    private val favoritePersistenceSource: PersistenceFavoritesSource,
    private val networkFavoritesSource: NetworkFavoritesSource
) {

    suspend fun getSavedFavorite(favoriteId: String) = favoritePersistenceSource.getPersistedFavorite(favoriteId)

    suspend fun getSavedFavorites() = favoritePersistenceSource.getPersistedFavorites()

    @Throws(Exception::class)
    suspend fun requestNewAFavorites(): List<Favorite>? {
        val newFavorites = networkFavoritesSource.getNetworkFavorites()
        favoritePersistenceSource.saveFavorites(newFavorites)
        return getSavedFavorites()
    }

}