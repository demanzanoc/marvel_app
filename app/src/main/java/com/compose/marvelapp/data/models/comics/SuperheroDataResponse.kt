package com.compose.marvelapp.data.models.comics

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(
    @SerializedName("data") val dataResponse: SuperheroResultsResponse
)
