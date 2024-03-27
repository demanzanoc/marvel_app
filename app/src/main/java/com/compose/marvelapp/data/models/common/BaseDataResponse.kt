package com.compose.marvelapp.data.models.common

import com.google.gson.annotations.SerializedName

data class BaseDataResponse<T>(
    @SerializedName("data") val data: BaseDataResults<T>,
)