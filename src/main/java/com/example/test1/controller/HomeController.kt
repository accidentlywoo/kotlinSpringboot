package com.example.test1.controller

import com.example.test1.domain.Article
import com.example.test1.domain.User
import com.example.test1.repository.ArticleRespository
import com.example.test1.util.format
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.server.ResponseStatusException

@Controller
class HomeController(private val repository: ArticleRespository) {
	@GetMapping("/")
	fun home(model: Model) : String{
		model["title"] = "On Boarduing" // []접근할라면 import org.springframework.ui.set 해야됨 ??
		model["article"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }

		return "index"
	}

	@GetMapping("/article/{slug}")
	fun article(@PathVariable slug: String, model: Model): String {
		val article = repository
			.findBySlug(slug)
			?.render()
			?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
		model["title"] = article.title
		model["article"] = article
		return "article"
	}

	fun Article.render() = RenderedArticle(
		slug,
		title,
		headLine,
		content,
		author,
		addedAt.format()
	)

	data class RenderedArticle(
		val slug: String,
		val title: String,
		val headLine: String,
		val content: String,
		val author: User,
		val addedAt: String
	)
}