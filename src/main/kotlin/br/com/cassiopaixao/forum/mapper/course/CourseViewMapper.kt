package br.com.cassiopaixao.forum.mapper.course

import br.com.cassiopaixao.forum.dto.course.CourseView
import br.com.cassiopaixao.forum.mapper.Mapper
import br.com.cassiopaixao.forum.model.Course
import org.springframework.stereotype.Component

@Component
class CourseViewMapper : Mapper<Course, CourseView> {

    override fun map(c: Course): CourseView {
        return CourseView(
            id = c.id,
            name = c.name,
            category = c.category
        )
    }
}