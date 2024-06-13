package sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(basePackages = ["sample.domain"])
class CssApplication

fun main(args: Array<String>) {
    runApplication<CssApplication>(*args)
}