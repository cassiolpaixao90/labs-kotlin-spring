package br.com.cassiopaixao.forum.mapper.user

import br.com.cassiopaixao.forum.dto.user.UserForm
import br.com.cassiopaixao.forum.mapper.Mapper
import br.com.cassiopaixao.forum.model.User
import org.springframework.stereotype.Component

@Component
class UserFormMapper : Mapper<UserForm, User> {

    override fun map(u: UserForm): User {
        return User(
            name = u.name, email = u.email
        )
    }
}
