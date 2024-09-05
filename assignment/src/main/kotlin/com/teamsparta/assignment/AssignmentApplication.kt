package com.teamsparta.assignment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@SpringBootApplication
class AssignmentApplication

fun main(args: Array<String>) {
	runApplication<AssignmentApplication>(*args)
}
