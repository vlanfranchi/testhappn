package com.jehutyno.data.articles

import com.jehutyno.domain.model.Article


interface PersistenceArticlesSource {

    suspend fun getPersistedArticle(articleId: String): Article?
    suspend fun getPersistedArticles(): List<Article>?
    suspend fun saveArticles(articles: List<Article>?)

}