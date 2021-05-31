package com.example.test1.study

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class BigDecimalTest {


	@Test
	fun `dec - decrease`() {
		var one = 1

		val big = BigDecimal(one)

		assertThat(--one).isEqualTo(big.dec().toInt())
	}
	
	@Test
	fun `div - divide`() {
		val big_ten = BigDecimal(10)
		val big_two = BigDecimal(2)

		assertThat(BigDecimal(5)).isEqualTo(big_ten.div(big_two))
	}
	
	@Test
	fun `inc - increase`() {
		var one = 1

		val big = BigDecimal(one)

		assertThat(++one).isEqualTo(big.inc().toInt())
	}

	@Test
	fun `minus`() {
		val big_ten = BigDecimal(10)
		val big_two = BigDecimal(2)

		assertThat(BigDecimal(8)).isEqualTo(big_ten.minus(big_two))
	}
	
	@Test
	fun `plus`() {
		val big_ten = BigDecimal(10)
		val big_two = BigDecimal(2)

		assertThat(BigDecimal(12)).isEqualTo(big_ten.plus(big_two))
	}

	@Test
	fun `rem - remainder`() {
		val big_ten = BigDecimal(10)
		val big_three = BigDecimal(3)

		assertThat(BigDecimal(1)).isEqualTo(big_ten.rem(big_three))
	}

	@Test
	fun `times`() {
		val big_four = BigDecimal(4)
		val big_two = BigDecimal(2)

		assertThat(BigDecimal(8)).isEqualTo(big_two.times(big_four))
	}
	
	@Test
	fun `unary minus`() {
		val big_four = BigDecimal(4)
		println(big_four.unaryMinus())
	}
}