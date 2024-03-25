package com.compose.marvelapp.data.repositories.comics

import com.compose.marvelapp.data.api.comics.retrofit.RetrofitComicsClient
import com.compose.marvelapp.data.models.comics.SuperheroDataResponse
import com.compose.marvelapp.domain.repositories.comics.ComicsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ComicsRepositoryImpl : ComicsRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val client = retrofit.create(RetrofitComicsClient::class.java)

    override suspend fun getComicsBySuperhero(superheroName: String): SuperheroDataResponse {
        try {
            val response = client.getComicsBySuperhero(superheroName)
            if (response.isSuccessful) {
                return response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception("Error: ${response.code()}")
            }
        } catch (e: Exception) {
            throw Exception("Error: ${e.message}")
        }
    }

}