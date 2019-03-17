package com.jehutyno.data

import com.jehutyno.domain.model.Article


class ArticlesRepository(
    private val articlesPersistenceSource: PersistenceArticlesSource,
    private val networkArticlesSource: NetworkArticlesSource
) {

    fun getSavedArticles() = articlesPersistenceSource.getPersistedArticles()

    @Throws(Exception::class)
    suspend fun requestNewArticles(): List<Article> {
        val newArticles = networkArticlesSource.getNetworkArticles()
        articlesPersistenceSource.saveArticles(newArticles)
        return getSavedArticles()
    }

}