package com.example.test1.controller

import com.example.test1.domain.Article
import com.example.test1.domain.User
import com.example.test1.repository.ArticleRespository
import com.example.test1.repository.UserRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class HttpControllersTest(@Autowired val mockMvc: MockMvc) {
	
	@MockkBean
	private lateinit var userRepository: UserRepository
	
	@MockkBean
	private lateinit var articleRespository: ArticleRespository
	
	@Test
	fun `List articles`() {
		val maeve = User("maeve", "maeve", "woo", "Quak Quak")

		val spring5Article = Article("Spring Framework5", "Dear my Love Spring Boot...", "Lorem ipsum", "??" ,maeve)

		val spring3Article = Article("Spring Framework3", "oh my old old friend...", "Lorem ipsum", "??" ,maeve)

		every { articleRespository.findAllByOrderByAddedAtDesc() } returns listOf(spring3Article, spring5Article)

		mockMvc.perform(get("/").accept(MediaType.TEXT_HTML))
			.andExpect(status().isOk)
	}
}