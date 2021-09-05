package br.com.cassiopaixao.forum.mapper.user

import br.com.cassiopaixao.forum.dto.user.UserView
import br.com.cassiopaixao.forum.mapper.Mapper
import br.com.cassiopaixao.forum.model.User
import org.springframework.stereotype.Component

@Component
class UserViewMapper : Mapper<User, UserView> {

    override fun map(u: User): UserView {
        return UserView(
            id = u.id,
            name = u.name,
            email = u.email
        )
    }
}