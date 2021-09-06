package br.com.cassiopaixao.forum.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document()
data class Course(
    @Id
    var id: String? = null,

    val name: String,

    val category: String
)
