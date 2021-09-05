package br.com.cassiopaixao.forum.repository

import br.com.cassiopaixao.forum.model.Course
import org.springframework.data.mongodb.repository.MongoRepository

interface CourseRepository : MongoRepository<Course, String> {}