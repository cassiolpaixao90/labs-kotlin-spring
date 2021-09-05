package br.com.cassiopaixao.forum.repository

import br.com.cassiopaixao.forum.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {}