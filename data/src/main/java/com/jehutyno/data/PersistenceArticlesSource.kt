package com.jehutyno.data

import com.jehutyno.domain.model.Article


interface PersistenceArticlesSource {

    suspend fun getPersistedArticles(): List<Article>?
    suspend fun saveArticles(articles: List<Article>?)

}