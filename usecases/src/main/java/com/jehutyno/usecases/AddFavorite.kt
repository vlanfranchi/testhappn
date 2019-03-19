package com.jehutyno.usecases

import com.jehutyno.data.articles.FavoritesRepository

class AddFavorite(private val favoritesRepository: FavoritesRepository) {
    suspend operator fun invoke(favoriteId: String) = favoritesRepository.requestAddFavorites(favoriteId)
}