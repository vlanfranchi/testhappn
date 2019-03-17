package com.jehutyno.usecases

import com.jehutyno.data.ArticlesRepository
import com.jehutyno.domain.model.Article

class RequestNewArticles(private val articlesRepository: ArticlesRepository) {
    @Throws(Exception::class)
    suspend operator fun invoke(): List<Article> = articlesRepository.requestNewArticles()
}