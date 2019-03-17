package com.jehutyno.data

import com.jehutyno.domain.model.Article

interface NetworkArticlesSource {

    @Throws(Exception::class)
    suspend fun getNetworkArticles(): List<Article>

}