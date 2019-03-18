package com.jehutyno.data

import com.jehutyno.domain.model.Article


interface PersistenceArticlesSource {

    suspend fun getPersistedArticle(articleId: String): Article?
    suspend fun getPersistedArticles(): List<Article>?
    suspend fun saveArticles(articles: List<Article>?)

}