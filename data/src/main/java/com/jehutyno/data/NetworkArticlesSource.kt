package com.jehutyno.data

interface NetworkArticlesSource {

    suspend fun getNetworkArticles()

}