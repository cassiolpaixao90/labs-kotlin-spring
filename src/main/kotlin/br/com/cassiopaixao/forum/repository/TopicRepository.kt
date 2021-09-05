package br.com.cassiopaixao.forum.repository

import br.com.cassiopaixao.forum.model.Topic
import org.springframework.data.mongodb.repository.MongoRepository

interface TopicRepository : MongoRepository<Topic, String> {}