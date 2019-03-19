package com.jehutyno.usecases

import com.jehutyno.data.favorites.FavoritesRepository

class AddFavorite(private val favoritesRepository: FavoritesRepository) {
    suspend operator fun invoke(articleId: String) = favoritesRepository.requestAddFavorites(articleId)
}