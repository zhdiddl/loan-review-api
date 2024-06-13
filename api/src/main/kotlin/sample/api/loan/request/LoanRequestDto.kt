package sample.api.loan.request

class LoanRequestDto {
    data class LoanRequestInputDto(
        val userName: String,
        var userRegistrationNumber: String,
        val userIncomeAmount: Long
    ) {
        fun toUserInfoDto(userKey: String) =
            UserInfoDto(userKey, userName, userRegistrationNumber, userIncomeAmount)
    }

    data class LoanRequestOutputDto(
        val userKey: String
    )
}