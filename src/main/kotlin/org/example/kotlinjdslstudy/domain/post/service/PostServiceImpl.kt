package org.example.kotlinjdslstudy.domain.post.service

import org.example.kotlinjdslstudy.domain.comment.repository.CommentRepository
import org.example.kotlinjdslstudy.domain.post.model.PostResponse
import org.example.kotlinjdslstudy.domain.post.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
	private val postRepository: PostRepository,
	private val commentRepository: CommentRepository,
) : PostService {

	override fun findAllPostResponses(): List<PostResponse> {
		// post 조회
		val posts = postRepository.findAllResponses()

		// comment 조회
		val postIds = posts.map { it.id }
		val comments = commentRepository.findAllResponsesInPostIds(postIds)

		// 그룹핑
		val commentsByPost = comments.groupBy { it.postId }
		return posts.map { post ->
			post.copy(comments = commentsByPost[post.id] ?: emptyList())
		}
	}

}
