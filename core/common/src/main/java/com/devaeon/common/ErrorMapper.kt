package com.devaeon.common

interface ErrorMapper {
    operator fun invoke(throwable: Throwable): String
}