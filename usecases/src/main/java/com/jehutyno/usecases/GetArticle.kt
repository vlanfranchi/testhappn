package com.jehutyno.usecases

import com.jehutyno.data.ArticlesRepository
import com.jehutyno.domain.model.Article

class GetArticle(private val articlesRepository: ArticlesRepository) {
    suspend operator fun invoke(articleId: String): Article? = articlesRepository.getSavedArticle(articleId)
}