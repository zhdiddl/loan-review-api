package sample.kafka.dto

data class LoanRequestDto(
    val userKey: String,
    var userRegistrationNumber: String,
    val userName: String,
    val userIncomeAmount: Long
)