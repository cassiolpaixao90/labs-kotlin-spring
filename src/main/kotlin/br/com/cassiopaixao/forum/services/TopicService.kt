package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.dto.TopicForm
import br.com.cassiopaixao.forum.dto.TopicView
import br.com.cassiopaixao.forum.dto.UpdateTopicForm
import br.com.cassiopaixao.forum.exceptions.NotFoundException
import br.com.cassiopaixao.forum.mapper.TopicFormMapper
import br.com.cassiopaixao.forum.mapper.TopicViewMapper
import br.com.cassiopaixao.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService (
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found!"
) {

    fun list(): List<TopicView> {
        return topics.stream().map { t -> topicViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun findById(topicId: Long): TopicView {
        var topic =  topics.stream().filter { t -> t.id == topicId }
            .findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }
        return  topicViewMapper.map(topic)
    }

    fun create(topicForm: TopicForm): TopicView {
        var topic = topicFormMapper.map(topicForm);
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(updateTopicForm: UpdateTopicForm): TopicView {
        var topic =  topics.stream().filter { t -> t.id == updateTopicForm.id }
            .findFirst()
            .orElseThrow{NotFoundException(notFoundMessage)}

        val topicUpdated = Topic(
            id = updateTopicForm.id,
            title = updateTopicForm.title,
            message = updateTopicForm.message,
            author = topic.author,
            course = topic.course,
            response = topic.response,
            status = topic.status,
            dateCreated = topic.dateCreated
        )

        topics = topics.minus(topic).plus(topicUpdated)

        return topicViewMapper.map(topicUpdated)
    }

    fun delete(id: Long) {
        var topic =  topics.stream().filter { t -> t.id == id }
            .findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }

        topics = topics.minus(topic)
    }
}