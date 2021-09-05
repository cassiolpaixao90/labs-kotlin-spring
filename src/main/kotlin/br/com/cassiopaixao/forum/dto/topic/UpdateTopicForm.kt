package br.com.cassiopaixao.forum.dto.topic

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UpdateTopicForm(

    @field:NotEmpty
    val id: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val title: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 250)
    val message: String
)
