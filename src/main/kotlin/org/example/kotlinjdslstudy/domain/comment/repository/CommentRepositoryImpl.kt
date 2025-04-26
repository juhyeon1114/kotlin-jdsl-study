package org.example.kotlinjdslstudy.domain.comment.repository

import org.example.kotlinjdslstudy.domain.comment.model.CommentEntity
import org.example.kotlinjdslstudy.domain.comment.model.CommentResponse
import org.example.kotlinjdslstudy.domain.post.model.PostEntity
import org.springframework.stereotype.Repository

@Repository
class CommentRepositoryImpl(
	private val commentJpaRepository: CommentJpaRepository,
) : CommentRepository {

	override fun findAllResponsesInPostIds(postIds: List<Long>): List<CommentResponse> {
		return commentJpaRepository.findAll {
			selectNew<CommentResponse>(
				path(CommentEntity::id),
				path(CommentEntity::content),
				path(CommentEntity::post)(PostEntity::id)
			)
				.from(
					entity(CommentEntity::class)
				)
				.where(
					path(CommentEntity::id).`in`(postIds)
				)
		}.filterNotNull()
	}

}
