package sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EntityScan(basePackages = ["sample.domain"])
@ComponentScan(basePackages = ["sample.kafka", "sample.api", "sample.domain"])
@EnableCaching
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
