package org.example.kotlinjdslstudy.domain.post.repository

import org.example.kotlinjdslstudy.domain.comment.model.CommentEntity
import org.example.kotlinjdslstudy.domain.comment.model.CommentResponse
import org.example.kotlinjdslstudy.domain.post.model.PostEntity
import org.example.kotlinjdslstudy.domain.post.model.PostResponse
import org.springframework.stereotype.Repository

@Repository
class PostRepositoryImpl(
	private val postJpaRepository: PostJpaRepository,
) : PostRepository {

	override fun findAllEntities(): List<PostEntity> {
		return postJpaRepository.findAll {
			select(
				entity(PostEntity::class)
			).from(
				entity(PostEntity::class),
				leftFetchJoin(CommentEntity::post),
			)
		}.filterNotNull()
	}

	override fun findAllResponses(): List<PostResponse> {
		return postJpaRepository.findAll {
			selectNew<PostResponse>(
				path(PostEntity::id),
				path(PostEntity::title),
				path(PostEntity::content),
			).from(
				entity(PostEntity::class),
				leftJoin(CommentEntity::post),
			)
		}.filterNotNull()
	}

	override fun deleteById(id: Long) {
		postJpaRepository.delete {
			deleteFrom(
				entity(PostEntity::class),
			).where(
				path(PostEntity::id).eq(id),
			)
		}
	}

}
