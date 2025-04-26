package org.example.kotlinjdslstudy.domain.post.repository

import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.example.kotlinjdslstudy.domain.post.model.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostJpaRepository : JpaRepository<PostEntity, Long>, KotlinJdslJpqlExecutor {
}
