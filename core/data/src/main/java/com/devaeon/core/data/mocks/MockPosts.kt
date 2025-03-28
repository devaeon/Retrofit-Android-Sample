package com.devaeon.core.data.mocks

import com.devaeon.core.data.dto.PostDto
import com.devaeon.core.domain.entity.Post

object MockPosts {
        private val TITLES = listOf(
            "Breaking News",
            "Tech Update",
            "Daily Post",
            "Random Thoughts",
            "Project Update"
        )

        private val BODIES = listOf(
            "This is a sample post body",
            "Some interesting content here",
            "Lorem ipsum dolor sit amet",
            "Another random post content",
            "Testing with random data"
        )

        private fun randomUserId() = (1..100).random()
        private fun randomId() = (1..1000).random()
        private fun randomTitle() = TITLES.random()
        private fun randomBody() = BODIES.random()


    fun createPost(
        userId: Int = randomUserId(),
        id: Int = randomId(),
        title: String = randomTitle(),
        body: String = randomBody()
    ) = Post(userId, id, title, body)

    fun createPostDto(
        userId: Int = randomUserId(),
        id: Int = randomId(),
        title: String = randomTitle(),
        body: String = randomBody()
    ) = PostDto(userId, id, title, body)

    fun createPostList(): List<Post> = listOf(createPost(), createPost())

    fun createPostDtoList(): List<PostDto> = listOf(createPostDto(), createPostDto())
}