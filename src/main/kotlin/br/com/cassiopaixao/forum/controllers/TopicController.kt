package br.com.cassiopaixao.forum.controllers

import br.com.cassiopaixao.forum.dto.topic.TopicForm
import br.com.cassiopaixao.forum.dto.topic.TopicView
import br.com.cassiopaixao.forum.dto.topic.UpdateTopicForm
import br.com.cassiopaixao.forum.services.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): TopicView {
        return service.findById(id)
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid topicForm: TopicForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicView> {
        val topicView = service.create(topicForm)
        val uri = uriBuilder.path("/topic/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid updateTopicForm: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.update(updateTopicForm)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }
}