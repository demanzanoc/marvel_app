package com.compose.marvelapp.data.repositories.comics

import com.compose.marvelapp.data.api.comics.retrofit.RetrofitComicsClient
import com.compose.marvelapp.data.api.common.toSecureUri
import com.compose.marvelapp.data.mappers.ComicMapper
import com.compose.marvelapp.data.models.comics.ComicItemResourceResponse
import com.compose.marvelapp.data.repositories.common.BaseRepository
import com.compose.marvelapp.domain.entities.comics.Comic
import com.compose.marvelapp.domain.repositories.comics.ComicsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(
    private val client: RetrofitComicsClient,
    private val dispatcher: CoroutineDispatcher,
) : ComicsRepository, BaseRepository() {

    override suspend fun getComicsBySuperhero(superheroName: String): List<Comic> {
        return withContext(dispatcher) {
            handleApiResponse {
                val response = client.getComicsBySuperhero(superheroName)
                if (response.isSuccessful) {
                    val itemsResourcesResponse =
                        response.body()?.data?.results?.getOrNull(0)?.comicsResourcesResponse?.itemsResourcesResponse
                    getComicsData(itemsResourcesResponse)
                } else {
                    throw Exception("Error: ${response.code()}")
                }
            }
        }
    }

    private suspend fun getComicsData(itemsResourcesResponse: List<ComicItemResourceResponse>?): List<Comic> {
        return withContext(dispatcher) {
            itemsResourcesResponse?.mapNotNull { resource ->
                resource.resourceUri?.let { resourceUri ->
                    val response = client.getComicsImages(resourceUri.toSecureUri())
                    if (response.isSuccessful) {
                        response.body()?.data?.results?.getOrNull(0)?.let {
                            ComicMapper.createComicEntityFromApi(it)
                        }
                    } else {
                        throw Exception("Error: ${response.code()}")
                    }
                }
            } ?: emptyList()
        }
    }

}