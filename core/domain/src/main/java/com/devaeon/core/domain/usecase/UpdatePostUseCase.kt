package com.devaeon.core.domain.usecase

import com.devaeon.core.domain.entity.Post
import com.devaeon.core.domain.repository.PostRepository
import javax.inject.Inject

class UpdatePostUseCase @Inject constructor(private val postRepository: PostRepository){
}