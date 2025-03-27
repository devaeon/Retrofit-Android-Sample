package com.devaeon.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

/**
 * Singleton object responsible for creating and providing a configured Retrofit instance.
 * This setup includes logging for debugging and a lenient Gson converter for handling
 * non-standard JSON responses.
 */
object RetrofitClient {

    /** Base URL for the Eclipse Git API */
    private const val BASE_URL = "https://git.eclipse.org/r/"

    /**
     * Logging interceptor to log HTTP request and response details.
     * Useful for debugging API requests and responses.
     */
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // Logs full request/response body
    }

    /**
     * OkHttpClient instance with added logging interceptor.
     * This ensures network requests are properly logged for debugging.
     */
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor) // Attach logging interceptor
        .build()


//    /**
//     * Lazy-initialized Retrofit service instance.
//     * Provides API access using the `EclipseApiService` interface.
//     */
//    val apiService: EclipseApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(LenientGsonConverterFactory.create())
//            .client(client) // Attach custom OkHttpClient
//            .build()
//            .create(EclipseApiService::class.java)
//    }
}
