package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.model.User
import br.com.cassiopaixao.forum.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun getById(userId: Long): User {
        return userRepository.getById(userId)
    }
}
