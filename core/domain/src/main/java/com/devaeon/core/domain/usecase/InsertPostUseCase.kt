package com.devaeon.core.domain.usecase

import com.devaeon.core.domain.entity.Post
import com.devaeon.core.domain.repository.PostRepository

class InsertPostUseCase(private val postRepository: PostRepository) {
    suspend operator fun invoke(post: Post) = postRepository.addPost(post)
}