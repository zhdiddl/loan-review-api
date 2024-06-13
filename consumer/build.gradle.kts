plugins {
}

version = "0.0.1"


dependencies {
    // Kafka
    implementation(project(":kafka"))
    implementation("org.springframework.kafka:spring-kafka")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Domain
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.6")
    implementation("org.springframework.boot:spring-boot-starter-web")

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.6.3")
        }
    }
}



