package com.example.test1.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

import org.assertj.core.api.Assertions.*
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTest(@Autowired val restTemplate: TestRestTemplate) {
	@Test
	fun `Assert blog page title, content and status code`() {
		println(">> Assert blog page title, content and status code")

		val entity = restTemplate.getForEntity<String>("/")

		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(entity.body).contains("Maeve", "마부 멍충이")
	    
	}
}