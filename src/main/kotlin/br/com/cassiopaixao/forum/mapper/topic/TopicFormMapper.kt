package br.com.cassiopaixao.forum.mapper.topic

import br.com.cassiopaixao.forum.dto.topic.TopicForm
import br.com.cassiopaixao.forum.mapper.Mapper
import br.com.cassiopaixao.forum.model.Course
import br.com.cassiopaixao.forum.model.Topic
import br.com.cassiopaixao.forum.model.User
import br.com.cassiopaixao.forum.services.CourseService
import br.com.cassiopaixao.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
) : Mapper<TopicForm, Topic> {

    override fun map(t: TopicForm): Topic {
        val course = courseService.getById(t.courseId)
        val user = userService.getById(t.authorId)

        return Topic(
            title = t.title,
            message = t.message,
            course = Course(course.id, course.name, course.category),
            author = User(user.id, user.name, user.email)
        )
    }
}
