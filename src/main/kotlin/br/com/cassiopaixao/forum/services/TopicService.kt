package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.dto.TopicForm
import br.com.cassiopaixao.forum.dto.TopicView
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
    private val topicFormMapper: TopicFormMapper
) {

    fun list(): List<TopicView> {
        return topics.stream().map { t -> topicViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun findById(topicId: Long): TopicView {
        var topic =  topics.stream().filter { t -> t.id == topicId }.findFirst().get()
        return  topicViewMapper.map(topic)
    }

    fun create(topicForm: TopicForm) {
        var topic = topicFormMapper.map(topicForm);
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }
}