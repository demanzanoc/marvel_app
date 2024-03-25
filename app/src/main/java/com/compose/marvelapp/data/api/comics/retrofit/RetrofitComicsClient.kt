package com.compose.marvelapp.data.api.comics.retrofit

import com.compose.marvelapp.data.api.common.API_KEY
import com.compose.marvelapp.data.api.common.HASH
import com.compose.marvelapp.data.api.common.TIMESTAMP
import com.compose.marvelapp.data.models.comics.SuperheroDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitComicsClient {

    @GET("/v1/public/characters")
    suspend fun getComicsBySuperhero(
        @Query("nameStartsWith") superheroName: String,
        @Query("ts") timestamp: Int = TIMESTAMP,
        @Query("apikey") apikey: String = API_KEY,
        @Query("hash") hash: String = HASH,
    ): Response<SuperheroDataResponse>

}