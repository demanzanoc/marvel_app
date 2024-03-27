package com.compose.marvelapp.data.mappers

import com.compose.marvelapp.data.api.common.toSecureUri
import com.compose.marvelapp.data.models.comics.ComicResponse
import com.compose.marvelapp.data.models.comics.ComicUrlImageResponse
import com.compose.marvelapp.domain.entities.comics.Comic

object ComicMapper {

    private const val noAvailableData = "Datos no diponibles"
    private const val noAvailableImage =
        "https://cdn.dribbble.com/users/2031583/screenshots/6242648/attachments/1337492/avengers404fullhd.png"

    fun createComicEntityFromApi(comicResponse: ComicResponse): Comic {
        return Comic(
            title = comicResponse.title ?: noAvailableData,
            description = comicResponse.description ?: noAvailableData,
            image = createComicImageFromApi(comicResponse.images?.firstOrNull())
        )
    }

    private fun createComicImageFromApi(comicUrlImageResponse: ComicUrlImageResponse?) =
        comicUrlImageResponse?.let {
            if (!it.path.isNullOrEmpty() && !it.extension.isNullOrEmpty())
                "${it.path}.${it.extension}".toSecureUri()
            else noAvailableImage
        } ?: noAvailableImage

}