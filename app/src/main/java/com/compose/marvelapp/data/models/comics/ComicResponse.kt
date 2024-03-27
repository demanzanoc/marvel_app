package com.compose.marvelapp.data.models.comics

import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("images") val images: List<ComicUrlImageResponse>?,
)
