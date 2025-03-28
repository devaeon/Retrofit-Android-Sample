package com.devaeon.network.utils

import retrofit2.Response

import com.devaeon.common.Result

suspend fun <T, R> handleApiResponse(
    apiCall: suspend () -> Response<T>,
    transform: suspend (T) -> Result<R>,
    mapError: ((Throwable) -> String)
): Result<R> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                transform(it)
            } ?: Result.Error(
                "Malformed data",
                IllegalStateException()
            )
        } else {
            Result.Error(
                "Request failed with code: ${response.code()}",
                IllegalStateException(response.message())
            )
        }
    } catch (e: Exception) {
        Result.Error(
            mapError.invoke(e),
            e
        )
    }
}