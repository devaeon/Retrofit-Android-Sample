package com.devaeon.core.domain.usecase

import com.devaeon.common.Result
import com.devaeon.core.domain.entity.Post
import com.devaeon.core.domain.repository.PostRepository
import javax.inject.Inject


class GetAllPostsUseCase @Inject constructor (private val postRepository: PostRepository) {
    suspend operator fun invoke(): Result<List<Post>> {
        return postRepository.getAllPosts()
    }
}