package br.com.cassiopaixao.forum.controllers

import br.com.cassiopaixao.forum.dto.course.CourseForm
import br.com.cassiopaixao.forum.dto.course.CourseView
import br.com.cassiopaixao.forum.services.CourseService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/courses")
class CourseController(private val service: CourseService) {

    @GetMapping
    fun list(): List<CourseView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): CourseView {
        return service.getById(id)
    }

    @PostMapping
    @Transactional
    fun create(@RequestBody @Valid courseForm: CourseForm, uriBuilder: UriComponentsBuilder): ResponseEntity<CourseView> {
        val courseView = service.create(courseForm)
        val uri = uriBuilder.path("/course/${courseView.id}").build().toUri()
        return ResponseEntity.created(uri).body(courseView)
    }

}