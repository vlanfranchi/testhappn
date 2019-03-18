package com.jehutyno.usecases

import com.jehutyno.data.articles.ArticlesRepository
import com.jehutyno.domain.model.Article

class GetArticles(private val articlesRepository: ArticlesRepository) {
    suspend operator fun invoke(): List<Article>? = articlesRepository.getSavedArticles()
}