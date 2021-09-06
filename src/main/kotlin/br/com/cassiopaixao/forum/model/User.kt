package br.com.cassiopaixao.forum.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Id
    var id: String? = null,

    @Indexed(unique = true)
    val name: String,

    @Indexed(unique = true)
    val email: String
)
