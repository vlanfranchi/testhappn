package com.jehutyno.data

import com.jehutyno.domain.model.Article


class ArticlesRepository(
    private val articlesPersistenceSource: PersistenceArticlesSource,
    private val networkArticlesSource: NetworkArticlesSource
) {

    suspend fun getSavedArticle(articleId: String) = articlesPersistenceSource.getPersistedArticle(articleId)

    suspend fun getSavedArticles() = articlesPersistenceSource.getPersistedArticles()

    @Throws(Exception::class)
    suspend fun requestNewArticles(): List<Article>? {
        val newArticles = networkArticlesSource.getNetworkArticles()
        articlesPersistenceSource.saveArticles(newArticles)
        return getSavedArticles()
    }

}