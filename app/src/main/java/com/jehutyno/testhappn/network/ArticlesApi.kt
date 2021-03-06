package com.jehutyno.testhappn.network

import com.jehutyno.domain.model.Article
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

const val BASE_URL: String = "http://192.168.43.23:3000"

interface ArticlesApi {

    @GET("/articles")
    fun getArticlesAsync(): Deferred<List<Article>>

}