package sample.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests { requests ->
                requests
                    .anyRequest().permitAll() // 모든 요청을 허용 (테스트 목적)
            }
            .csrf().disable() // CSRF 보호 비활성화 (테스트 목적)
        return http.build()
    }
}