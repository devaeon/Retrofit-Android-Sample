package com.devaeon.retrofit.interfaces

import com.devaeon.retrofit.model.Project
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


/**
 * Interface defining API endpoints for fetching project data from Eclipse's Git repository.
 * Provides multiple methods to handle API responses in different ways.
 */
interface EclipseApiService {

    /**
     * Fetches a list of projects using a **Retrofit Call**.
     * This method **does not use coroutines** and requires `enqueue()` or `execute()` to handle the response.
     *
     * @return A `Call` object containing a map where:
     * - The key is the project name.
     * - The value is a `Project` object containing project details.
     */
    @GET("projects/")
    fun getProjectsCall(): Call<Map<String, Project>>


    /**
     * Fetches a list of projects using a **suspend function with Coroutines**.
     * This method runs on a background thread when used within `viewModelScope` or `lifecycleScope`.
     *
     * @return A `Response` object containing a map of project data.
     * - If the request is successful, `Response.body()` contains the project map.
     * - If there's an error, `Response.errorBody()` provides error details.
     */
    @GET("projects/")
    suspend fun getProjectsResponse(): Response<Map<String, Project>>


    /**
     * Fetches a **raw response** as `ResponseBody`, useful when:
     * - The response structure is unknown or dynamic.
     * - You want to parse the response manually (e.g., using `JSONObject`).
     *
     * @return A `Call` object containing the raw `ResponseBody`, which needs to be converted to JSON manually.
     */
    @GET("projects/")
    fun getProjectsRaw(): Call<ResponseBody>
}
