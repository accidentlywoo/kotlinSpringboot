package com.example.test1.config

import com.example.test1.domain.Article
import com.example.test1.domain.User
import com.example.test1.repository.ArticleRespository
import com.example.test1.repository.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {
	@Bean
	fun databaseInitializer(
		userRepository: UserRepository,
		articleRespository: ArticleRespository) = ApplicationRunner {
		val maeve = userRepository.save(User("maeve", "maeve", "Woo"))

		articleRespository.save(Article(
			title = "Maeve는 코틀린킹이 되고싶다.",
			headLine = "마부 멍충이",
			content = "Kotlin은 어려워, 스프링도 어려워, JPA는 너무 어려웡",
			author = maeve
		))
	}
}