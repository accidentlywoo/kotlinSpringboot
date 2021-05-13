package com.example.test1.repository

import com.example.test1.domain.Article
import com.example.test1.domain.User
import org.springframework.data.repository.CrudRepository

interface ArticleRespository : CrudRepository<Article, Long> {
	fun findBySlug(slug: String): Article?
	fun findAllByOrderByAddedAtDesc() : Iterable<Article>
}

interface UserRepository : CrudRepository<User, Long> {
	fun findByLogin(login: String): User?
}