package sample.kafka.producer

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import sample.kafka.dto.LoanRequestDto
import sample.kafka.enum.KafkaTopic

@Component
class LoanRequestSender(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper
) {
    fun sendMessage(topic: KafkaTopic, loanRequestDto: LoanRequestDto) {
        kafkaTemplate.send(topic.topicName, objectMapper.writeValueAsString(loanRequestDto))
    }

}