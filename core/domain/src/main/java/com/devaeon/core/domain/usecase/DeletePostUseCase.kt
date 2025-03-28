package com.devaeon.core.domain.usecase

import com.devaeon.core.domain.repository.PostRepository
import javax.inject.Inject


class DeletePostUseCase @Inject constructor(private val postRepository: PostRepository){
    suspend operator fun invoke(postId: Int) = postRepository.deletePost(postId)
}