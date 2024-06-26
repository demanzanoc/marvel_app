package com.compose.marvelapp.data.models.comics

import com.google.gson.annotations.SerializedName

data class ComicsDataResponse(
    @SerializedName("comics") val comicsResourcesResponse: ComicsResourcesResponse,
)
