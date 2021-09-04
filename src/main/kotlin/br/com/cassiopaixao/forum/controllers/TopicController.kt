package br.com.cassiopaixao.forum.controllers

import br.com.cassiopaixao.forum.dto.TopicForm
import br.com.cassiopaixao.forum.dto.TopicView
import br.com.cassiopaixao.forum.dto.UpdateTopicForm
import br.com.cassiopaixao.forum.services.TopicService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController (private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid topicForm: TopicForm) {
        service.create(topicForm)
    }

    @PutMapping
    fun update(@RequestBody @Valid updateTopicForm: UpdateTopicForm){
        service.update(updateTopicForm)
    }
}