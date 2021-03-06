package br.com.cassiopaixao.forum.dto.topic

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class TopicForm(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 250, message = "Title must be between 5 and 10 char")
    val message: String,

    @field:NotEmpty
    val courseId: String,

    @field:NotEmpty
    val authorId: String
)
