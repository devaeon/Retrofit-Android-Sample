package com.devaeon.retrofit.converter

import com.google.gson.GsonBuilder
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A custom factory for creating a lenient Gson converter.
 * This allows Retrofit to handle non-standard or improperly formatted JSON.
 *
 * Usage:
 * ```
 * Retrofit.Builder()
 *     .addConverterFactory(LenientGsonConverterFactory.create())
 *     .build()
 * ```
 */
object LenientGsonConverterFactory {

    /**
     * Creates and returns a `Converter.Factory` that uses a lenient Gson instance.
     *
     * @return A `GsonConverterFactory` configured with a lenient Gson parser.
     */
    fun create(): Converter.Factory {
        val gson = GsonBuilder()
            .setLenient()  // Allows parsing of loosely formatted JSON
            .create()

        return GsonConverterFactory.create(gson)
    }
}
