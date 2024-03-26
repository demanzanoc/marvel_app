package com.compose.marvelapp.domain.repositories.comics

fun interface ComicsRepository {
    suspend fun getComicsBySuperhero(superheroName: String)
}