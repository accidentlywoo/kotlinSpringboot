package com.example.test1.domain

import com.example.test1.util.toSlug
import java.time.LocalDateTime
import javax.annotation.processing.Generated
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
	var title: String,
	var slug: String = title.toSlug(),
	var headLine: String,
	var content: String,
	@ManyToOne
	var author: User,
	var addedAt: LocalDateTime = LocalDateTime.now(),
	@Id
	@GeneratedValue
	var id : Long? = null
)

@Entity
class User(
	var login: String,
	var firstName: String,
	var lastName: String,
	var description: String? = null,
	@Id
	@GeneratedValue
	var id: Long? = null
)