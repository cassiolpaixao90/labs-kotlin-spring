package br.com.cassiopaixao.forum.controllers

import br.com.cassiopaixao.forum.model.Topic
import br.com.cassiopaixao.forum.services.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController (private val service: TopicService) {

    @GetMapping
    fun list(): List<Topic> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): List<Topic> {
        return service.findById(id)
    }
}