package com.devaeon.post.state

import com.devaeon.core.domain.entity.Post

sealed class PostListState {
    data object Loading : PostListState()
    data class Success(val posts: List<Post>) : PostListState()
    data class Error(val message: String) : PostListState()
}