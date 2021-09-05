package br.com.cassiopaixao.forum.dto

import br.com.cassiopaixao.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val dateCreated: LocalDateTime,
)
