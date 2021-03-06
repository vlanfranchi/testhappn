package com.jehutyno.usecases

import com.jehutyno.data.favorites.FavoritesRepository
import com.jehutyno.domain.model.Favorite

class RequestNewFavorites(private val favoritesRepository: FavoritesRepository) {
    @Throws(Exception::class)
    suspend operator fun invoke(): List<Favorite>? = favoritesRepository.requestNewFavorites()
}