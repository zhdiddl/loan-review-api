package sample.api.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    // http://localhost:8080/swagger-ui/index.html
    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("fintech-api") // API 그룹 이름 지정
            .pathsToMatch("/**") // Swagger 문서에 포함할 경로 패턴 지정
            .build()
    }

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("핀테크 대출 심사 API")
                    .version("1.0")
                    .description("대출 심사 API 입니다 :)")
            )
    }
}