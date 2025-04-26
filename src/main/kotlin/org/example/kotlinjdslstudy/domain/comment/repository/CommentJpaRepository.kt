package org.example.kotlinjdslstudy.domain.comment.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.example.kotlinjdslstudy.domain.comment.model.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CommentJpaRepository : JpaRepository<CommentEntity, Long>, KotlinJdslJpqlExecutor {
}
