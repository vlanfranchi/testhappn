package com.jehutyno.data.articles

import com.jehutyno.domain.model.Article


class ArticlesRepository(
    private val articlesPersistenceSource: PersistenceFavoritesSource,
    private val networkArticlesSource: NetworkFavoritesSource
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