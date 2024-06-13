plugins {}

version = "0.0.1"

dependencies {
    // spring-boot-starters
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.3")
    implementation("org.springframework.hateoas:spring-hateoas")

    // spring-security
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-config")
    implementation("org.springframework.security:spring-security-web")

    // project modules
    implementation(project(":domain"))
    implementation(project(":kafka"))

    // swagger
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    implementation("org.springdoc:springdoc-openapi-data-rest:1.6.9")

    // jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.+")

    //testing
    testImplementation("io.mockk:mockk:1.12.0")
    runtimeOnly("com.h2database:h2")

    // AOP
    implementation("org.springframework.boot:spring-boot-starter-aop")

    // logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")

    // Redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // Kafka
    implementation ("org.springframework.kafka:spring-kafka")
    testImplementation ("org.springframework.kafka:spring-kafka-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:2.6.3")
    }
}