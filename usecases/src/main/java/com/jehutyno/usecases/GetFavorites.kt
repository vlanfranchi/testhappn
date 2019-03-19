package com.jehutyno.usecases

import com.jehutyno.data.favorites.FavoritesRepository
import com.jehutyno.domain.model.Favorite

class GetFavorites(private val favoritesRepository: FavoritesRepository) {
    suspend operator fun invoke(): List<Favorite>? = favoritesRepository.getSavedFavorites()
}