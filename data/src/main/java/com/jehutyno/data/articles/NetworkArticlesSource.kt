package com.jehutyno.data.articles

import com.jehutyno.domain.model.Article

interface NetworkArticlesSource {

    @Throws(Exception::class)
    suspend fun getNetworkArticles(): List<Article>

}