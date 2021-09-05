package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.model.Course
import br.com.cassiopaixao.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {

    fun getById(id: Long): Course {
        return courseRepository.getById(id)
    }
}
