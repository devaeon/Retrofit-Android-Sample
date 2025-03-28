package com.devaeon.core.domain.usecase

import com.devaeon.common.Result
import com.devaeon.core.domain.entity.Post
import com.devaeon.core.domain.repository.PostRepository


class GetPostByPostIdUseCase(private val postRepository: PostRepository) {
    suspend operator fun invoke(userId: Int): Result<Post> {
        return postRepository.getPostByPostId(userId)
    }
}