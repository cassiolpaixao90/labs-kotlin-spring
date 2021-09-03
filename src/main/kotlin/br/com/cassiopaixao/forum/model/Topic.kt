package br.com.cassiopaixao.forum.model

import java.time.LocalDateTime

data class Topic (
    val id: Long? = null,
    val title: String,
    val message: String,
    val dateCreated: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val response: List<Response> = ArrayList()
)