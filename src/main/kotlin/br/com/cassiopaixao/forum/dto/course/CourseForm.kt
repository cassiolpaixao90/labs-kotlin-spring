package br.com.cassiopaixao.forum.dto.course

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class CourseForm(
    @field:NotEmpty
    @field:Size(max = 100)
    val name: String,

    @field:NotEmpty
    @field:Size(max = 100)
    val category: String
)
