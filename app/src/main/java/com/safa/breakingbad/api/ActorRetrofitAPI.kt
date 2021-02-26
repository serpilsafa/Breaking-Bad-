package com.safa.breakingbad.api

import com.safa.breakingbad.model.Actor
import retrofit2.Response
import retrofit2.http.GET

interface ActorRetrofitAPI {

    @GET("/api/characters")
    suspend fun getActor(): Response<Actor>

}