package br.com.cassiopaixao.forum.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import kotlin.collections.ArrayList

@Document
data class Topic(
    @Id
    var id: String? = null,

    var title: String,

    var message: String,

    val dateCreated: LocalDateTime = LocalDateTime.now(),

    val course: Course,

    val author: User,

    val status: TopicStatus = TopicStatus.NOT_ANSWERED,

    val response: List<Response> = ArrayList()
)