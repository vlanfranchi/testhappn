package com.jehutyno.testhappn.framework

import com.jehutyno.data.articles.PersistenceFavoritesSource
import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.database.ArticleDAO

class RoomArticlesPersistenceSource(private val articlesDao: ArticleDAO) :
    PersistenceFavoritesSource {

    override suspend fun getPersistedArticle(articleId: String): Article? = ArticleRoomConverter.convert(articlesDao.getAllArticle(articleId))

    override suspend fun getPersistedArticles(): List<Article>? = ArticleRoomConverter.convert(articlesDao.getAllArticles())

    override suspend fun saveArticles(articles: List<Article>?) {
        articlesDao.deleteAllArticles()
        articlesDao.addArticles(RoomArticleConverter.convert(articles))
    }
}