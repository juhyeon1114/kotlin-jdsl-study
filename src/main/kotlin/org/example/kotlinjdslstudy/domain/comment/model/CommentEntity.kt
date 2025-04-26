package org.example.kotlinjdslstudy.domain.comment.model

import jakarta.persistence.*
import org.example.kotlinjdslstudy.domain.post.model.PostEntity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Table(name = "comment")
@Entity
@DynamicInsert
@DynamicUpdate
class CommentEntity(
	var content: String,
	var writeUserId: Long,
) {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	var post: PostEntity? = null

}
