package sample.consumer.dto

import sample.domain.domain.LoanReview

data class ReviewResponseDto(
    val userKey: String,
    val limitAmount: Long,
    val interest: Double
) {
    fun toLocalReviewEntity(): LoanReview =
        LoanReview(
            userKey = userKey,
            loanInterest = interest,
            loanLimitAmount = limitAmount
        )

}