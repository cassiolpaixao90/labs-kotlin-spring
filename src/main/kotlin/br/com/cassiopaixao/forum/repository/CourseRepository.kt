package br.com.cassiopaixao.forum.repository

import br.com.cassiopaixao.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {}