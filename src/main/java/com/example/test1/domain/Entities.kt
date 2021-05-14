package com.example.test1.domain

import com.example.test1.util.toSlug
import java.time.LocalDateTime
import javax.annotation.processing.Generated
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
	@Id @Generated
	var id : Long? = null,
	var title: String,
	var headLine: String,
	var content: String,
	@ManyToOne
	var author: User,
	var slug: String = title.toSlug(),
	var addedAt: LocalDateTime = LocalDateTime.now()
)

@Entity
class User(
	@Id @Generated
	var id: Long? = null,
	var login: String,
	var firstName: String,
	var lastName: String,
	var description: String? = null
)