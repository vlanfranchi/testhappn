package com.jehutyno.testhappn.network

import com.jehutyno.domain.model.AddFavoriteRequest
import com.jehutyno.domain.model.EmptyResponse
import com.jehutyno.domain.model.Favorite
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface FavoritesApi {

    @GET("/favorites")
    fun getFavoritesAsync(): Deferred<List<Favorite>>

    @POST("/favorites")
    fun addFavoriteAsync(@Body addFavoriteRequest: AddFavoriteRequest): Deferred<Favorite>

    @DELETE("/favorites/{favorite_id}")
    fun removeFavoriteAsync(@Path("favorite_id") favoriteId: String): Deferred<EmptyResponse>

}