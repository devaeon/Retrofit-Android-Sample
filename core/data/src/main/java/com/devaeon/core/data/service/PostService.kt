package com.devaeon.core.data.service

import com.devaeon.core.data.dto.PostDto
import com.devaeon.core.domain.entity.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @GET("posts/{postId}")
    suspend fun getPostByPostId(@Path("postId") postId: Int): Response<PostDto>

    @GET("posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): Response<List<Post>>

    @GET("posts")
    suspend fun getPosts(): Response<List<PostDto>>

    @POST("posts")
    suspend fun createPost(@Body post: Post): Response<Post>

    @PATCH("posts/{id}")
    suspend fun updatePost(@Path("id") id: Int, @Body updatedPost: Post): Response<Post>

    @DELETE("posts/{id}")
    suspend fun deletePost(@Path("id") id: Int): Response<Unit>
}