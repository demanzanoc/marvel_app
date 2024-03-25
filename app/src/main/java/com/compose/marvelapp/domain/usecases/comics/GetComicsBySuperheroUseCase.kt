package com.compose.marvelapp.domain.usecases.comics

import com.compose.marvelapp.data.models.comics.SuperheroDataResponse
import com.compose.marvelapp.domain.repositories.comics.ComicsRepository
import javax.inject.Inject

class GetComicsBySuperheroUseCase @Inject constructor(private val repository: ComicsRepository) {

    suspend operator fun invoke(superheroName: String): SuperheroDataResponse =
        repository.getComicsBySuperhero(superheroName)

}