package com.example.test1.study

import org.junit.jupiter.api.Test

class ApplyWithLetAlsoRun {
	/**
	 * HOF : High Order Function 인 Apply, With, Let, Also, Run 트레이닝
	 * 이 다섯가지 함수를 배울때, 이놈들은 비슷비슷해서 언제 사용해야하는지 , 어떻게 사용하는 지 잘 기억하자
	 */

	@Test
	fun `With`() {
		/**
		 *  With function의 signature :
		 *
		 * inline fun <T, R> with(receiver: T, block: T.() -> R): R {
		 *	    return receiver.block()
		 *	}
		 */
		class Person (
			var name: String? = null,
			var age: Int? = null
		)

		val person: Person = Person("마부", 1)
		println(person.name)
		println(person.age)

		with(person) {
			println(name)
			println(age)
		}
		/** with()를 사용해 person 변수 사용의 반복을 줄이기위해 범위를 쌈싸버렸다. **/
	}

	@Test
	fun `Also`() {
		/**
		 *  Also function의 signature :
		 *
		 * iinline fun <T> T.also(block: (T) -> Unit): T {
		 *    block(this)
		 *    return this
		 * }
		 */
		class Person (
			var name: String? = null,
			var age: Int? = null
		)

		Person("마부", 1).also {
			println(it.name)
			println(it.age)
		}
	}

	@Test
	fun `Apply`() {
		/**
		 *  Apply function의 signature :
		 *
		 * inline fun <T> T.apply(block: T.() -> Unit): T {
		 *    block()
		 *    return this
		 * }
		 */
		class Person (
			var name: String? = null,
			var age: Int? = null
		)

		val apply = Person().apply {
			// Only Access Properties In Apply Block
			name = "maeve"
			age = 18
		}

		println(apply.name)
		println(apply.age)

		/** equivalent **/
		val maeve = Person()
		maeve.name = "maeve"
		maeve.age = 18

		println(maeve.name)
		println(maeve.age)
	}

	@Test
	fun `Let`() {
		class Person (
			var name: String? = null,
			var age: Int? = null
		)

		Person("maeve", 18 )?.let {
		// only executed when not-null
			println(it.name)
			println(it.age)
		}

		Person("maeve", 17).let { p ->
			// scope of p variable is limited to this block
			println(p.name)
		}
	}

	@Test
	fun `Run`() {
		class Person (
			var name: String? = null,
			var age: Int? = null
		)

		val person = Person("maeve", 18)

		fun printAge (person: Person) = person.run {
			println(age)
		}

		printAge(person)
	}
}