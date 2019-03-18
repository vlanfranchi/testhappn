package com.jehutyno.testhappn.network

import com.jehutyno.domain.model.AddFavoriteRequest
import com.jehutyno.domain.model.Favorite
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FavoritesApi {

    @GET("/favorites")
    fun getFavoritesAsync(): Deferred<List<Favorite>>

    @POST("/favorites")
    fun adFavoriteAsync(@Body addFavoriteRequest: AddFavoriteRequest): Deferred<Favorite>

}