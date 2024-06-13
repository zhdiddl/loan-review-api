package sample.consumer.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import sample.consumer.service.LoanRequestService
import sample.kafka.dto.LoanRequestDto

@Service
class LoanRequestConsumer(
    private val objectMapper: ObjectMapper,
    private val loanRequestService: LoanRequestService
) {
    @KafkaListener(topics = ["loan_request"], groupId = "fintech")
    fun loanRequestTopicConsumer(message: String) {
        val loanRequestKafkaDto = objectMapper.readValue(message, LoanRequestDto::class.java)

        loanRequestService.loanRequest(loanRequestKafkaDto)
    }
}