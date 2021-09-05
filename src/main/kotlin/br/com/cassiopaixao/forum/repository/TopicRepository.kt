package br.com.cassiopaixao.forum.repository

import br.com.cassiopaixao.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long> {}