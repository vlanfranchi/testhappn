package com.jehutyno.data

import com.jehutyno.domain.model.Article


interface PersistenceArticlesSource {

    fun getPersistedArticles(): List<Article>
    fun saveArticles(articles: List<Article>)

}