package com.example.test1.domain

import com.example.test1.util.toSlug
import java.time.LocalDateTime
import javax.annotation.processing.Generated
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
	var title: String,
	var headline: String,
	var content: String,
	@ManyToOne var author: User,
	var slug: String = title.toSlug(),
	var addedAt: LocalDateTime = LocalDateTime.now(),
	@Id @Generated var id : Long? = null)

@Entity
class User(
	var login: String,
	var firstname: String,
	var lastname: String,
	var description: String? = null,
	@Id @Generated var id: Long? = null
)