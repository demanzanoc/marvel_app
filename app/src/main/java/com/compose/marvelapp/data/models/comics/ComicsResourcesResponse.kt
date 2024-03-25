package com.compose.marvelapp.data.models.comics

import com.google.gson.annotations.SerializedName

data class ComicsResourcesResponse(
    @SerializedName("items") val itemsResourcesResponse: List<ComicItemResourceResponse>
)
