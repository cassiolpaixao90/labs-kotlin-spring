package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.dto.TopicDto
import br.com.cassiopaixao.forum.model.Topic
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicService (
    private var topics: List<Topic> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun list(): List<Topic> {
        return topics
    }

    fun findById(topicId: Long): Topic {
        return topics.stream().filter { t ->
            t.id == topicId
        }.findFirst().get()
    }

    fun create(topicDto: TopicDto) {
        topics = topics.plus(Topic(
            id = topics.size.toLong() + 1,
            title = topicDto.title,
            message = topicDto.message,
            course = courseService.getById(topicDto.courseId),
            author = userService.getById(topicDto.authorId)
        ))
    }
}