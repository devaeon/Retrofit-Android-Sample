package com.devaeon.core.domain.repository

import com.devaeon.common.Result
import com.devaeon.core.domain.entity.Post


interface PostRepository {
    suspend fun getAllPosts(): Result<List<Post>>

    suspend fun getPostByPostId(postId: Int): Result<Post>
    suspend fun getPostsByUserId(userId: Int): Result<List<Post>>

    suspend fun addPost(post: Post): Result<Post>
    suspend fun updatePost(post: Post): Result<Post>
    suspend fun deletePost(postId: Int): Result<Boolean>
}