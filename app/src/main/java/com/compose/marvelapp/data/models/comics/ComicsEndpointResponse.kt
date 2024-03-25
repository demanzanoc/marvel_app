package com.compose.marvelapp.data.models.comics

import com.google.gson.annotations.SerializedName

data class ComicsEndpointResponse(
    @SerializedName("comics") val comicsResourcesResponse: ComicsResourcesResponse
)
