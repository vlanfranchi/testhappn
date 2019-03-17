package com.jehutyno.testhappn.framework

import com.jehutyno.data.PersistenceArticlesSource
import com.jehutyno.domain.model.Article

class RoomArticlesPersistenceSource: PersistenceArticlesSource {

    private var articles: List<Article> = emptyList()

    override fun getPersistedArticles(): List<Article> = articles

    override fun saveArticles(articles: List<Article>) {
        this.articles = articles
    }
}