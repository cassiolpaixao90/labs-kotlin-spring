package br.com.cassiopaixao.forum.repository

import br.com.cassiopaixao.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {}