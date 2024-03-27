package com.compose.marvelapp.domain.repositories.comics

import com.compose.marvelapp.domain.entities.comics.Comic

fun interface ComicsRepository {
    suspend fun getComicsBySuperhero(superheroName: String): List<Comic>
}