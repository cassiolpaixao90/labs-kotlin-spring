package br.com.cassiopaixao.forum.mapper.topic

import br.com.cassiopaixao.forum.dto.topic.TopicForm
import br.com.cassiopaixao.forum.mapper.Mapper
import br.com.cassiopaixao.forum.model.Topic
import br.com.cassiopaixao.forum.services.CourseService
import br.com.cassiopaixao.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
) : Mapper<TopicForm, Topic> {

    override fun map(t: TopicForm): Topic {
        return Topic(
            id = "",
            title = t.title,
            message = t.message,
            course = null,
            author = null
        )
    }
}
