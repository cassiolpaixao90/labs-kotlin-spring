package br.com.cassiopaixao.forum.dto.user

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UserForm(
    @field:NotEmpty
    @field:Size(max = 100)
    val name: String,

    @field:Email
    val email: String
)
