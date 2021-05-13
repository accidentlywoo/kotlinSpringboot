package com.example.test1.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity

import org.assertj.core.api.Assertions.*
import org.springframework.http.HttpStatus


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WelcomControllerTest(@Autowired val restTemplate: TestRestTemplate) {
     @Test
     fun `Assert Welcome page test`() {
         val entity = restTemplate.getForEntity<String>("/welcome/")
         assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
         assertThat(entity.body).contains("<h1>Welcome! On Boarding</h1>")
     }
}