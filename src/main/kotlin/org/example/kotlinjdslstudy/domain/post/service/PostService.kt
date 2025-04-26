package org.example.kotlinjdslstudy.domain.post.service

import org.example.kotlinjdslstudy.domain.post.model.PostResponse

interface PostService {

	fun findAllPostResponses(): List<PostResponse>

}
