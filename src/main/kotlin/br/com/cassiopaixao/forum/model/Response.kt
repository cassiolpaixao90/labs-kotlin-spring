package br.com.cassiopaixao.forum.model

import java.time.LocalDateTime

data class Response (
    val id: Long? = null,
    val message: String,
    val dateCreated: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solution: Boolean
)
