package sample.api.loan.request

import sample.domain.domain.UserInfo
import sample.kafka.dto.LoanRequestDto

data class UserInfoDto(
    val userKey: String,
    val userRegistration: String,
    val userName: String,
    val userIncomeAmount: Long
) {
    fun toEntity(): UserInfo = UserInfo(userKey, userRegistration, userName, userIncomeAmount)

    fun toLoanRequestKafkaDto() = LoanRequestDto(
        userKey, userRegistration, userName, userIncomeAmount)
}
