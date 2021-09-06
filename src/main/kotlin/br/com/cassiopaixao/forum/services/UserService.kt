package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.dto.user.UserForm
import br.com.cassiopaixao.forum.dto.user.UserView
import br.com.cassiopaixao.forum.exceptions.NotFoundException
import br.com.cassiopaixao.forum.mapper.user.UserFormMapper
import br.com.cassiopaixao.forum.mapper.user.UserViewMapper
import br.com.cassiopaixao.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userFormMapper: UserFormMapper,
    private val userViewMapper: UserViewMapper
) {

    fun getById(userId: String): UserView {
        val user = userRepository.findById(userId).orElseThrow { NotFoundException("not found user") }
        return userViewMapper.map(user)
    }

    fun create(userForm: UserForm): UserView {
        val user = userFormMapper.map(userForm)
        userRepository.save(user)
        return userViewMapper.map(user)
    }
}
