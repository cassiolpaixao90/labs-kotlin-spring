package br.com.cassiopaixao.forum.dto

data class TopicDto (
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long
)
