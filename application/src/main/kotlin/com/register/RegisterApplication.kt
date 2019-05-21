package com.register

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class RegisterApplication

fun main(args: Array<String>) {
    runApplication<RegisterApplication>(*args)
}