package sample.consumer.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * Spring Data JPA를 사용해서
 * 데이터베이스 접근을 위한 리포지토리 설정과 데이터 감사 기능
 */
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["sample.domain"])
class JpaAuditingConfiguration {
}