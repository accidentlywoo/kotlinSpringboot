package com.example.test1.study

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class BigDecimalTest {

	@Test
	fun `init BigDecimal`() {
		val big_1000 = BigDecimal("1000")
		val big_1000_123 = BigDecimal("1000.123")

		assertThat(BigDecimal("1000")).isEqualTo(big_1000)
		assertThat(BigDecimal("1000.123")).isEqualTo(big_1000_123)

		assertThat(BigDecimal(1000)).isEqualTo(big_1000)
		assertThat(BigDecimal(1000.123)).isEqualTo(big_1000_123)
	}
	
	@Test
	fun `Compare Bigdecimal`() {
		val big_1000 = BigDecimal("1000")
		val big_2_1000 = BigDecimal("1000")
		val big_1000_123 = BigDecimal("1000.123")

		assertThat(big_1000).isEqualByComparingTo(big_2_1000);
		assertThat(big_1000).isNotEqualByComparingTo(big_1000_123);
	}

	@Test
	fun `증가 연산자`() {
		val big_1000_123 = BigDecimal("1000.123")

		assertThat(BigDecimal("1001.123"))
			.isEqualByComparingTo(big_1000_123.inc())
	}

	@Test
	fun `감소 연산자`() {
		val big_1000_123 = BigDecimal("1000.123")

		assertThat(BigDecimal("999.123"))
			.isEqualByComparingTo(big_1000_123.dec())
	}

	@Test
	fun `더하기 연산자`() {
		val big_1000 = BigDecimal("1000")
		val big_1000_123 = BigDecimal("1000.123")

		assertThat(BigDecimal("2000.123"))
			.isEqualByComparingTo(big_1000_123.plus(big_1000))
	}

	@Test
	fun `뻬기 연산자`() {
		val big_1000 = BigDecimal("1000")
		val big_1000_123 = BigDecimal("1000.123")

		assertThat(BigDecimal("0.123"))
			.isEqualByComparingTo(big_1000_123.minus(big_1000))
	}

	@Test
	fun `곱하기 연산자`() {
		val big_2 = BigDecimal("2")
		val big_1000_123 = BigDecimal("1000.123")

		assertThat(BigDecimal("2000.246"))
			.isEqualByComparingTo(big_1000_123.times(big_2))
	}

	@Test
	fun `나누기 연산자`() {
		val big_2 = BigDecimal("2")
		val big_3 = BigDecimal("3").setScale(1)
		val big_1000_123 = BigDecimal("1000.123").setScale(4)

		println(big_1000_123.div(big_2))

		assertThat(BigDecimal("500.0615"))
			.isEqualByComparingTo(big_1000_123.div(big_2))

		println(big_3.div(big_2))

		assertThat(BigDecimal("1.5"))
			.isEqualByComparingTo(big_3.div(big_2))
	}

	@Test
	fun `나머지 연산자`() {
		val big_2 = BigDecimal("2")
		val big_3 = BigDecimal("3").setScale(1)
		val big_1000_123 = BigDecimal("1000.123").setScale(4)

		assertThat(BigDecimal("0.123"))
			.isEqualByComparingTo(big_1000_123.rem(big_2))

		assertThat(BigDecimal("1"))
			.isEqualByComparingTo(big_3.rem(big_2))
	}

	@Test
	fun `단항음 연산자`() {
		val big_2 = BigDecimal("2")

		assertThat(BigDecimal("-2"))
			.isEqualByComparingTo(big_2.unaryMinus())
	}

	@Test
	fun `소숫점 자릿수 비교`() {

		assertThat(BigDecimal("1000.0"))
			.isEqualByComparingTo(BigDecimal("1000"))

		assertThat(BigDecimal("1000.0"))
			.isEqualByComparingTo(BigDecimal("1000.00000"))

		assertThat(BigDecimal("1000"))
			.isEqualByComparingTo(BigDecimal("1000.00000"))

		assertThat(1000.0)
			.isEqualByComparingTo(1000.0000000000000000001)

		assertThat(BigDecimal("1000"))
			.isEqualByComparingTo(BigDecimal("1000.0000000000000000001"))
	}
//	operator fun BigDecimal.div(other: BigDecimal): BigDecimal
//	= this.divide(other, 4, RoundingMode.HALF_EVEN)
}

