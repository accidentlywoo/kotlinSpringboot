package com.example.test1.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

internal class ExtensionsKtTest {
	@Test
	fun toSlug() {
	    println("뭐야 어떻게 쓰눈 고양".toSlug())
	}
	
	@Test
	fun `locale date time format`() {
	    println(LocalDateTime.now().format())
	}
}