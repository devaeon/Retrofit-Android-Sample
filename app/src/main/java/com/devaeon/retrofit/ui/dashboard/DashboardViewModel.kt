package com.devaeon.retrofit.ui.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devaeon.retrofit.RetrofitClient
import com.devaeon.retrofit.model.Project
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class DashboardViewModel : ViewModel() {

    private val _projectsState = MutableStateFlow<UiState<Map<String, Project>>>(UiState.Loading)
    val projectsState: StateFlow<UiState<Map<String, Project>>> = _projectsState

    /**
     * Fetches the list of projects using Retrofit's Call-based method.
     * Uses enqueue() for asynchronous execution.
     */
    fun fetchProjectsCall() {
        _projectsState.value = UiState.Loading

        val call = RetrofitClient.apiService.getProjectsCall()
        call.enqueue(object : retrofit2.Callback<Map<String, Project>> {
            override fun onResponse(
                call: retrofit2.Call<Map<String, Project>>,
                response: retrofit2.Response<Map<String, Project>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    _projectsState.value = UiState.Success(response.body()!!)
                    Log.d("API Response", "Fetched ${response.body()!!.size} projects")
                } else {
                    _projectsState.value = UiState.Error("Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<Map<String, Project>>, t: Throwable) {
                _projectsState.value = UiState.Error("Failed to fetch projects: ${t.message}")
                Log.e("API Failure", "Error: ${t.message}")
            }
        })
    }

    /**
     * Fetches the list of projects using a suspend function and Retrofit's Response-based method.
     * Uses Kotlin coroutines and Flow for better async handling.
     */
    fun fetchProjectsResponse() {
        viewModelScope.launch {
            _projectsState.value = UiState.Loading
            try {
                val response = RetrofitClient.apiService.getProjectsResponse()

                if (response.isSuccessful && response.body() != null) {
                    _projectsState.value = UiState.Success(response.body()!!)
                    Log.d("API Response", "Fetched ${response.body()!!.size} projects")
                } else {
                    _projectsState.value = UiState.Error("Response failed: ${response.code()}")
                    Log.e("API Failure", "Error: ${response.code()} ${response.message()}")
                }
            } catch (e: IOException) {
                _projectsState.value = UiState.Error("Network error: ${e.message}")
                Log.e("API Failure", "IOException: ${e.message}")
            } catch (e: HttpException) {
                _projectsState.value = UiState.Error("HTTP error: ${e.message}")
                Log.e("API Failure", "HttpException: ${e.message}")
            }
        }
    }

    /**
     * Fetches the raw response from the API.
     * Uses Retrofit's Call-based method to retrieve the raw JSON response.
     */
    fun fetchProjectsRaw() {
        val call = RetrofitClient.apiService.getProjectsRaw()
        call.enqueue(object : retrofit2.Callback<okhttp3.ResponseBody> {
            override fun onResponse(
                call: retrofit2.Call<okhttp3.ResponseBody>,
                response: retrofit2.Response<okhttp3.ResponseBody>
            ) {
                if (response.isSuccessful) {
                    val rawResponse = response.body()?.string()
                    Log.d("API Raw Response", "Response: $rawResponse")
                } else {
                    Log.e("API Error", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<okhttp3.ResponseBody>, t: Throwable) {
                Log.e("API Failure", "Failed to fetch projects: ${t.message}")
            }
        })
    }
}


private const val TAG = "DashboardViewModel"

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}
