package com.devaeon.core.data.mapper

import com.devaeon.core.data.dto.PostDto
import com.devaeon.core.domain.entity.Post

fun PostDto.toPost(): Post {
    return Post(
        userId = this.userId, id = this.id, title = this.title, body = this.body
    )
}
