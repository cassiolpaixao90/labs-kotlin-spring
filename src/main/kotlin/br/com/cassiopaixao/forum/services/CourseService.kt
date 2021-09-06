package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.dto.course.CourseForm
import br.com.cassiopaixao.forum.dto.course.CourseView
import br.com.cassiopaixao.forum.exceptions.NotFoundException
import br.com.cassiopaixao.forum.mapper.course.CourseFormMapper
import br.com.cassiopaixao.forum.mapper.course.CourseViewMapper
import br.com.cassiopaixao.forum.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CourseService(
    private val courseRepository: CourseRepository,
    private val courseViewMapper: CourseViewMapper,
    private val userFormMapper: CourseFormMapper
    ) {

    fun getById(id: String): CourseView {
        val course = courseRepository.findById(id).orElseThrow { NotFoundException("not found course") };
        return courseViewMapper.map(course)
    }

    fun create(courseForm: CourseForm): CourseView {
        val course = userFormMapper.map(courseForm)
        courseRepository.save(course)
        return courseViewMapper.map(course)
    }

    fun list(): List<CourseView> {
        val topics = courseRepository.findAll();
        return topics.stream().map { t -> courseViewMapper.map(t) }.collect(Collectors.toList())
    }
}
