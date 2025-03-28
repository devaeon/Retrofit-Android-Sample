package com.devaeon.core.domain.usecase

import com.devaeon.core.domain.repository.PostRepository
import javax.inject.Inject


class GetPostsByUserIdUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend operator fun invoke(userId: Int) = postRepository.getPostsByUserId(userId)
}