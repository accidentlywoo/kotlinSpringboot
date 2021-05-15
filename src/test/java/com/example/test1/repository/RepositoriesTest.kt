package com.example.test1.repository

import com.example.test1.domain.Article
import com.example.test1.domain.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit.jupiter.SpringExtension

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoriesTests @Autowired constructor(
	val entityManager: TestEntityManager,
	val userRepository: UserRepository,
	val articleRespository: ArticleRespository) {
	
	@Test
	fun `When findByIdOrNull then return Article`() {
		val juergen = User("springjuergen", "Juergen", "Hoeller")
		entityManager.persist(juergen)

		val article = Article("Springboot king!", "꺄아앙", "헛소뤼", "content", juergen)
		entityManager.persist(article)

		entityManager.flush()

		val found = articleRespository.findByIdOrNull(article.id!!) // ???느낌표 두개 머선 129

		assertThat(found).isEqualTo(article)
	}
	
	@Test
	fun `When findByLogin then return User`() {
		val maeve = User("spring boot", "yeonhui", "woo")
		entityManager.persist(maeve)

		val user = userRepository.findByLogin(maeve.login)

	  assertThat(user).isEqualTo(maeve)
	}
}