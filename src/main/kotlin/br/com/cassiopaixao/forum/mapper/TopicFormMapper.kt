package br.com.cassiopaixao.forum.mapper

import br.com.cassiopaixao.forum.dto.TopicForm
import br.com.cassiopaixao.forum.model.Topic
import br.com.cassiopaixao.forum.services.CourseService
import br.com.cassiopaixao.forum.services.UserService
import org.springframework.stereotype.Component


@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
): Mapper<TopicForm, Topic> {

    override fun map(t: TopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.getById(t.courseId),
            author = userService.getById(t.authorId)
        )
    }
}
