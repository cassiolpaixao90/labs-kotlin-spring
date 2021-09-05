package br.com.cassiopaixao.forum.dto.topic

import br.com.cassiopaixao.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: String?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val dateCreated: LocalDateTime,
)
