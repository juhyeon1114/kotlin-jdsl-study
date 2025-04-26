package org.example.kotlinjdslstudy.domain.post.repository

import org.example.kotlinjdslstudy.domain.post.model.PostEntity
import org.example.kotlinjdslstudy.domain.post.model.PostResponse

interface PostRepository {

	fun findAllEntities(): List<PostEntity>

	fun findAllResponses(): List<PostResponse>

	fun deleteById(id: Long)

}
