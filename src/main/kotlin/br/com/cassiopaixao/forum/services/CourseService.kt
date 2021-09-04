package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService (var courses: List<Course>) {

    init {
        val course = Course(id = 1, name = "kotlin", category = "test")
        courses = Arrays.asList(course)
    }

    fun getById (id: Long): Course {
        return courses.stream().filter{ c -> c.id == id }.findFirst().get()
    }
}
