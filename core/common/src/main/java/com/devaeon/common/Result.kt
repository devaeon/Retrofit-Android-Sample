package com.devaeon.common

sealed class Result<out D> {

    val isSuccess: Boolean get() = this is Success
    val isError: Boolean get() = this is Error

    class Success<out D>(val data: D) : Result<D>()

    class Error(val message: String, val exception: Throwable) : Result<Nothing>()
}

fun <D> Result<D>.getOr(fallback: D): D = if (this is Result.Success) { this.data } else { fallback }

fun <D> Result<D>.exceptionOrNull(): Throwable? =
    if (this is Result.Error) {
        this.exception
    } else {
        null
    }

fun <D> Result<D>.messageOrNull(): String? =
    if (this is Result.Error) {
        this.message
    } else {
        null
    }

inline fun <D> Result<D>.fold(
    onSuccess: (D) -> Unit,
    onError: (String, Throwable) -> Unit,
) {
    when (this) {
        is Result.Success -> onSuccess(this.data)
        is Result.Error -> onError(this.message, this.exception)
    }
}

