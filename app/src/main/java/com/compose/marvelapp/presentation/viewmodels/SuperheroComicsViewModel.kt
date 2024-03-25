package com.compose.marvelapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.marvelapp.domain.usecases.comics.GetComicsBySuperheroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroComicsViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsBySuperheroUseCase,
): ViewModel() {

    fun getComics(superheroName: String) {
     viewModelScope.launch {
         val result = getComicsUseCase(superheroName)
         println(result.dataResponse.comicsList[0].comicsResourcesResponse.itemsResourcesResponse[0].resourceUri)
     }
    }

}