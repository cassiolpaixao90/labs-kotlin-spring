package br.com.cassiopaixao.forum.services

import br.com.cassiopaixao.forum.model.Course
import br.com.cassiopaixao.forum.model.Topic
import br.com.cassiopaixao.forum.model.User
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicService (private var topics: List<Topic>) {

    init {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "Variaveis no Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topic2 = Topic(
            id = 2,
            title = "Duvida Kotlin 2",
            message = "Variaveis no Kotlin 2",
            course = Course (
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User (
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topic3 = Topic(
            id = 3,
            title = "Duvida Kotlin 3",
            message = "Variaveis no Kotlin 3",
            course = Course (
                id = 1,
                name = "Kotlin",
                category = "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        topics = Arrays.asList(topic, topic2, topic3)
    }

    fun list(): List<Topic> {
        return topics;
    }

    fun findById(topicId: Long): List<Topic> {
        return topics.stream().filter { r -> r.id ==  topicId }.collect(Collectors.toList())
    }
}