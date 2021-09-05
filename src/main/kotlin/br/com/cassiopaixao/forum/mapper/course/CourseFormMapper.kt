package br.com.cassiopaixao.forum.mapper.course

import br.com.cassiopaixao.forum.dto.course.CourseForm
import br.com.cassiopaixao.forum.mapper.Mapper
import br.com.cassiopaixao.forum.model.Course
import org.springframework.stereotype.Component

@Component
class CourseFormMapper : Mapper<CourseForm, Course> {

    override fun map(c: CourseForm): Course {
        return Course(
            name = c.name, category = c.category
        )
    }
}
