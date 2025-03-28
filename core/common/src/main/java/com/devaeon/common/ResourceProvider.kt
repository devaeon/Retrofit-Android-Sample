package com.devaeon.common

interface ResourceProvider {
    fun getString(resId: Int): String
    fun <T> getString(resId: Int, vararg formatArgs: T): String
}
