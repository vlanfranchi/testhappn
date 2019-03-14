package com.jehutyno.usecases

import com.jehutyno.data.ArticlesRepository
import com.jehutyno.domain.model.Article

class GetArticles(private val articlesRepository: ArticlesRepository) {
    operator fun invoke(): List<Article> = articlesRepository.getSavedArticles()
}