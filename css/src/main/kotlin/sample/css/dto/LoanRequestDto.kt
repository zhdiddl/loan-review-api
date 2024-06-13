package sample.css.dto

class LoanRequestDto {
    data class RequestInputDto(
        val userKey: String,
        var userRegistrationNumber: String,
        val userName: String,
        val userIncomeAmount: Long
    )
}