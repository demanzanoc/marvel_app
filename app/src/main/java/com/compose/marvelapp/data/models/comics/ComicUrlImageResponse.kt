package com.compose.marvelapp.data.models.comics

import com.google.gson.annotations.SerializedName

data class ComicUrlImageResponse(
    @SerializedName("path") val path: String?,
    @SerializedName("extension") val extension: String?,
)