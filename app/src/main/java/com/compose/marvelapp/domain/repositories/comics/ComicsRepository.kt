package com.compose.marvelapp.domain.repositories.comics

import com.compose.marvelapp.data.models.comics.SuperheroDataResponse

interface ComicsRepository {
    suspend fun getComicsBySuperhero(superheroName: String): SuperheroDataResponse
}