package br.com.victor.utilmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class UtilManagerApplication

fun main(args: Array<String>) {
	runApplication<UtilManagerApplication>(*args)
}
