package br.com.cassiopaixao.forum.mapper.topic

import br.com.cassiopaixao.forum.dto.topic.TopicView
import br.com.cassiopaixao.forum.mapper.Mapper
import br.com.cassiopaixao.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            dateCreated = t.dateCreated,
            status = t.status
        )
    }
}