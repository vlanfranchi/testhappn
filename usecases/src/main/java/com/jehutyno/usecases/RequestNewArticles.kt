package com.jehutyno.usecases

import com.jehutyno.data.ArticlesRepository
import com.jehutyno.domain.model.Article

class RequestNewArticles(private val articlesRepository: ArticlesRepository) {
    suspend operator fun invoke(): List<Article> = articlesRepository.requestNewArticles()
}