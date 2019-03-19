package com.jehutyno.usecases

import com.jehutyno.data.articles.FavoritesRepository

class RemoveFavorite(private val favoritesRepository: FavoritesRepository) {
    suspend operator fun invoke(favoriteId: String) = favoritesRepository.requestRemoveFavorites(favoriteId)
}