package br.com.cassiopaixao.forum.controllers

import br.com.cassiopaixao.forum.dto.user.UserForm
import br.com.cassiopaixao.forum.dto.user.UserView
import br.com.cassiopaixao.forum.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid userForm: UserForm, uriBuilder: UriComponentsBuilder): ResponseEntity<UserView> {
        val userView = service.create(userForm)
        val uri = uriBuilder.path("/user/${userView.id}").build().toUri()
        return ResponseEntity.created(uri).body(userView)
    }

}