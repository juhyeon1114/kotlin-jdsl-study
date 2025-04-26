package org.example.kotlinjdslstudy.domain.comment.repository

import org.example.kotlinjdslstudy.domain.comment.model.CommentResponse

interface CommentRepository {

	fun findAllResponsesInPostIds(postIds: List<Long>): List<CommentResponse>

}
