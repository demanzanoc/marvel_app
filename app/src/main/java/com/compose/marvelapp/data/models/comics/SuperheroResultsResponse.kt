package com.compose.marvelapp.data.models.comics

import com.google.gson.annotations.SerializedName

data class SuperheroResultsResponse(
    @SerializedName("results") val comicsList: List<ComicsEndpointResponse>
)
