package com.devaeon.core.data.repository

import com.devaeon.common.ErrorMapper
import com.devaeon.common.Result
import com.devaeon.core.data.mapper.toPost
import com.devaeon.core.data.service.PostService
import com.devaeon.core.domain.entity.Post
import com.devaeon.core.domain.repository.PostRepository
import com.devaeon.network.utils.handleApiResponse
import javax.inject.Inject


class PostRepositoryImpl @Inject constructor(
    private val postService: PostService,
    private val errorMapper: ErrorMapper
) : PostRepository {

    override suspend fun getAllPosts(): Result<List<Post>> {
        return handleApiResponse(
            apiCall = { postService.getPosts() },
            transform = { dtoResponse ->
                val posts = dtoResponse.map { it.toPost() }
                Result.Success(posts)
            },
            mapError = errorMapper::invoke
        )
    }

    override suspend fun getPostByPostId(postId: Int): Result<Post> {
        return handleApiResponse(
            apiCall = { postService.getPostByPostId(postId) }, transform = {
                Result.Success(it.toPost())
            }, mapError = errorMapper::invoke
        )
    }


    override suspend fun getPostsByUserId(userId: Int): Result<List<Post>> {
        return handleApiResponse(
            apiCall = { postService.getPostsByUserId(userId) },
            transform = { Result.Success(it) },
            mapError = errorMapper::invoke
        )
    }

    override suspend fun addPost(post: Post): Result<Post> {
        return handleApiResponse(
            apiCall = { postService.createPost(post) },
            transform = { Result.Success(it) },
            mapError = errorMapper::invoke
        )
    }

    override suspend fun updatePost(post: Post): Result<Post> {
        return handleApiResponse(
            apiCall = { postService.updatePost(post.id, post) },
            transform = { Result.Success(it) },
            mapError = errorMapper::invoke
        )
    }

    override suspend fun deletePost(postId: Int): Result<Boolean> {
        return handleApiResponse(
            apiCall = { postService.deletePost(postId) },
            transform = { Result.Success(true) },
            mapError = errorMapper::invoke
        )
    }
}