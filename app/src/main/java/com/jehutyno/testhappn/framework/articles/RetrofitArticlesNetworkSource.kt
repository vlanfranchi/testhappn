package com.jehutyno.testhappn.framework.articles

import com.jehutyno.data.articles.NetworkArticlesSource
import com.jehutyno.domain.model.Article
import com.jehutyno.testhappn.network.ArticlesApi

class RetrofitArticlesNetworkSource(private val articleApi: ArticlesApi):
    NetworkArticlesSource {

    @Throws(Exception::class)
    override suspend fun getNetworkArticles(): List<Article> {
        return articleApi.getArticlesAsync().await()
    }

}