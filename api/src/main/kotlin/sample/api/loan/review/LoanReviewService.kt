package sample.api.loan.review

import sample.domain.domain.LoanReview

interface LoanReviewService {
    fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewOutputDto

    fun getLoanResult(userKey: String): LoanReview?


}