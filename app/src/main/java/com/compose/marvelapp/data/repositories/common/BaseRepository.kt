package com.compose.marvelapp.data.repositories.common

open class BaseRepository {

    protected suspend fun <T> handleApiResponse(call: suspend () -> T): T {
        try {
            return call.invoke()
        } catch (exception: Exception) {
            throw Exception("Error: ${exception.message}")
        }
    }

}