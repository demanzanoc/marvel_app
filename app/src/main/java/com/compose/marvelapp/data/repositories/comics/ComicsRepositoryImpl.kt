package com.compose.marvelapp.data.repositories.comics

import com.compose.marvelapp.data.api.comics.retrofit.RetrofitComicsClient
import com.compose.marvelapp.data.api.common.toSecureUri
import com.compose.marvelapp.data.models.comics.ComicItemResourceResponse
import com.compose.marvelapp.data.repositories.common.BaseRepository
import com.compose.marvelapp.domain.repositories.comics.ComicsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(
    private val client: RetrofitComicsClient,
    private val dispatcher: CoroutineDispatcher,
) : ComicsRepository, BaseRepository() {

    override suspend fun getComicsBySuperhero(superheroName: String) {
        withContext(dispatcher) {
            handleApiResponse {
                val response = client.getComicsBySuperhero(superheroName)
                if (response.isSuccessful) {
                    response.body()?.let {
                        getComicsData(
                            it.data.results[0].comicsResourcesResponse.itemsResourcesResponse
                        )
                    }
                } else {
                    throw Exception("Error: ${response.code()}")
                }
            }
        }
    }

    private suspend fun getComicsData(itemsResourcesResponse: List<ComicItemResourceResponse>?) {
        withContext(dispatcher) {
            itemsResourcesResponse?.map { resource ->
                resource.resourceUri?.let { resourceUri ->
                    val response = client.getComicsImages(resourceUri.toSecureUri())
                    if (response.isSuccessful) {
                        response.body()?.let {
                            val image = it.data.results[0].images
                            if (!image.isNullOrEmpty()) {
                                println(it.data.results[0].images)
                            }
                        }
                    } else {
                        throw Exception("Error: ${response.code()}")
                    }
                }
            }
        }
    }

}