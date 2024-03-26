package com.compose.marvelapp.data.models.comics

import com.google.gson.annotations.SerializedName

data class ComicItemResourceResponse(
    @SerializedName("resourceURI") val resourceUri: String?,
)
