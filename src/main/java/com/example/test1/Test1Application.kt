package com.example.test1

import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Test1Application

fun main(args: Array<String>) {
    runApplication<Test1Application>(*args)
}
