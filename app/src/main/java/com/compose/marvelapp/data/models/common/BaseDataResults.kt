package com.compose.marvelapp.data.models.common

import com.google.gson.annotations.SerializedName

data class BaseDataResults<T>(
    @SerializedName("results") val results: List<T>,
)