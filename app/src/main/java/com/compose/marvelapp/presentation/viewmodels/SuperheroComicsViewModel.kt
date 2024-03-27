package com.compose.marvelapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.marvelapp.domain.entities.comics.Comic
import com.compose.marvelapp.domain.usecases.comics.GetComicsBySuperheroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroComicsViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsBySuperheroUseCase,
) : ViewModel() {

    private val _comics = MutableLiveData<List<Comic>>()
    val comics: LiveData<List<Comic>> = _comics
    private var superheroNameCached = ""

    fun getComics(superheroName: String) {
        if (shouldGetComics(superheroName))
            viewModelScope.launch {
                try {
                    _comics.value = getComicsUseCase(superheroName)
                } catch (exception: Exception) {
                    throw Exception(exception)
                }
            }
    }

    private fun shouldGetComics(superheroName: String): Boolean {
        return if (superheroName != superheroNameCached) {
            superheroNameCached = superheroName
            true
        } else false
    }

}