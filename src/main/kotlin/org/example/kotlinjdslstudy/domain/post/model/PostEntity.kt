package org.example.kotlinjdslstudy.domain.post.model

import jakarta.persistence.*
import org.example.kotlinjdslstudy.domain.comment.model.CommentEntity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Table(name = "post")
@Entity
@DynamicInsert
@DynamicUpdate
class PostEntity(
	var title: String,
	var content: String,
) {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
	var comments: MutableList<CommentEntity> = mutableListOf()

}
