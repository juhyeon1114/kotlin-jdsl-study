package org.example.kotlinjdslstudy.domain.post.model

import org.example.kotlinjdslstudy.domain.comment.model.CommentResponse

data class PostResponse(
	val id: Long,
	val title: String,
	val content: String,
	val comments: List<CommentResponse>
)
