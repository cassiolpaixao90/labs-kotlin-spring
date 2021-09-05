package br.com.cassiopaixao.forum.dto.course

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UpdateCourseForm(

    @field:NotEmpty
    val id: String,

    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val name: String,

    @field:NotEmpty
    @field:Size(min = 10, max = 250)
    val description: String
)
