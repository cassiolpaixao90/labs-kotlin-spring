package br.com.cassiopaixao.forum.model

import javax.persistence.*

@Entity
data class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String
)
