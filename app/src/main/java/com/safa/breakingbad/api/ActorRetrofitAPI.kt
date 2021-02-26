package com.safa.breakingbad.api

import com.safa.breakingbad.model.Actor
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

interface ActorRetrofitAPI {

    @GET("/api/characters")
    suspend fun getActor(): Response<Actor>

    @GET("/api/characters")
    suspend fun getActors(): ArrayList<Actor>
}