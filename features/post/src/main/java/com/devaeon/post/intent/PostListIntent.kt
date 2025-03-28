package com.devaeon.post.intent
sealed class PostListIntent {
    data object LoadPosts : PostListIntent()
}