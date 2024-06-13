package sample.consumer.service

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import sample.consumer.dto.ReviewResponseDto
import sample.domain.domain.LoanReview
import sample.domain.repository.LoanReviewRepository
import sample.kafka.dto.LoanRequestDto
import java.time.Duration

@Service
@EntityScan(basePackages = ["sample.domain"])
class LoanRequestService(
    private val loanReviewRepository: LoanReviewRepository
) {
    companion object {
        const val nginxUrl = "http://nginx:8085/css/api/v1/request"
    }

    fun loanRequest(loanRequestDto: LoanRequestDto) {
        val reviewResult = loanRequestToCb(loanRequestDto)

        saveLoanReviewData(reviewResult.toLocalReviewEntity())
    }

    private fun loanRequestToCb(loanRequestDto: LoanRequestDto): ReviewResponseDto {
        val restTemplate = RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000))
            .setReadTimeout(Duration.ofMillis(1000))
            .build()

        return restTemplate.postForEntity(nginxUrl, loanRequestDto, ReviewResponseDto::class.java).body!!
    }

    private fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)
}