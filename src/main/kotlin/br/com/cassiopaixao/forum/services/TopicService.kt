package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService (private var topics: List<Topic> = ArrayList()) {

    fun list(): List<Topic> {
        return topics
    }

    fun findById(topicId: Long): List<Topic> {
        return topics.stream().filter { r -> r.id ==  topicId }.collect(Collectors.toList())
    }

    fun create(topic: Topic) {
        topics.plus(topic)
    }
}