package com.jehutyno.usecases

import com.jehutyno.data.favorites.FavoritesRepository

class RemoveFavorite(private val favoritesRepository: FavoritesRepository) {
    suspend operator fun invoke(articleId: String, favoriteId: String) = favoritesRepository.requestRemoveFavorites(articleId, favoriteId)
}