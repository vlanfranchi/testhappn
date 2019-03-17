package com.jehutyno.testhappn.framework

import com.jehutyno.data.NetworkArticlesSource
import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.network.ArticlesApi

class RetrofitArticlesPersistenceSource(private val articleApi: ArticlesApi): NetworkArticlesSource {

    override suspend fun getNetworkArticles(): List<Article> {
        return articleApi.getTripsAsync().await()
    }

}