package com.jehutyno.testhappn.framework.favorites

import com.jehutyno.data.articles.PersistenceFavoritesSource
import com.jehutyno.domain.model.Favorite
import com.jehutyno.testhappn.database.favorites.FavoriteDAO

class RoomFavoritesPersistenceSource(private val favoriteDAO: FavoriteDAO) :
    PersistenceFavoritesSource {

    override suspend fun getPersistedFavorite(favoriteId: String): Favorite? = FavoriteRoomConverter.convert(favoriteDAO.getFavorite(favoriteId))

    override suspend fun getPersistedFavorites(): List<Favorite>? = FavoriteRoomConverter.convert(favoriteDAO.getAllFavorites())

    override suspend fun saveFavorites(favorites: List<Favorite>?) {
        favoriteDAO.deleteAllFavorites()
        favoriteDAO.addFavorites(RoomFavoriteConverter.convert(favorites))
    }
}