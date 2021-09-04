package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (var users: List<User>) {

    init {
        val user = User(id = 1, name = "User 1", email = "test@gmail.com")
        users = Arrays.asList(user)
    }

    fun getById(userId: Long): User {
        return users.stream().filter{ u -> u.id == userId }.findFirst().get()
    }
}
