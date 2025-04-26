package org.example.kotlinjdslstudy.domain.comment.model

data class CommentResponse(
	val commentId: Long,
	val content: String,
	val postId: Long,
)

