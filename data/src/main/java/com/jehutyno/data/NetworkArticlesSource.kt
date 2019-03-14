package com.jehutyno.data

import com.jehutyno.domain.model.Article

interface NetworkArticlesSource {

    suspend fun getNetworkArticles(): List<Article>

}