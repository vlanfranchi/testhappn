package com.jehutyno.usecases

import com.jehutyno.data.favorites.FavoritesRepository
import com.jehutyno.domain.model.Favorite

class GetFavorite(private val favoritesRepository: FavoritesRepository) {
    suspend operator fun invoke(favoriteId: String): Favorite? = favoritesRepository.getSavedFavorite(favoriteId)
}