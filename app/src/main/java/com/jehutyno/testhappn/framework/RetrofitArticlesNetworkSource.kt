package com.jehutyno.testhappn.framework

import com.jehutyno.data.articles.NetworkFavoritesSource
import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.network.ArticlesApi

class RetrofitArticlesNetworkSource(private val articleApi: ArticlesApi):
    NetworkFavoritesSource {

    @Throws(Exception::class)
    override suspend fun getNetworkArticles(): List<Article> {
        return articleApi.getTripsAsync().await()
    }

}