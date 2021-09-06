package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.dto.topic.TopicForm
import br.com.cassiopaixao.forum.dto.topic.TopicView
import br.com.cassiopaixao.forum.dto.topic.UpdateTopicForm
import br.com.cassiopaixao.forum.exceptions.NotFoundException
import br.com.cassiopaixao.forum.mapper.topic.TopicFormMapper
import br.com.cassiopaixao.forum.mapper.topic.TopicViewMapper
import br.com.cassiopaixao.forum.repository.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found!"
) {

    fun list(): List<TopicView> {
        var topics = topicRepository.findAll();
        return topics.stream().map { t -> topicViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun findById(topicId: String): TopicView {
        var topic = topicRepository.findById(topicId)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return topicViewMapper.map(topic)
    }

    fun create(topicForm: TopicForm): TopicView {
        var topic = topicFormMapper.map(topicForm)
        topicRepository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(updateTopicForm: UpdateTopicForm): TopicView {
        val topic = topicRepository.findById(updateTopicForm.id)
            .orElseThrow { NotFoundException(notFoundMessage) }

        topic.title = updateTopicForm.title
        topic.message = updateTopicForm.message

        return topicViewMapper.map(topic)
    }

    fun delete(id: String) {
        topicRepository.deleteById(id)
    }
}