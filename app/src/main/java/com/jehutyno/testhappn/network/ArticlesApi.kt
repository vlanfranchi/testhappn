package com.jehutyno.testhappn.network

import com.jehutyno.domain.model.Article
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

const val BASE_URL: String = "http://localhost"

interface ArticlesApi {

    @GET("/articles")
    fun getTripsAsync(): Deferred<List<Article>>

}