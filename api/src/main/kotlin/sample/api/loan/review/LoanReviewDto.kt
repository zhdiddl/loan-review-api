package sample.api.loan.review

class LoanReviewDto {
    // 최종 응답 구조 (클라이언트에게 반환할 데이터)
    data class LoanReviewOutputDto(
        val userKey: String,
        val loanResult: LoanResult
    )

    // 대출 결과 (응답에 사용될 데이터)
    data class LoanResult(
        val userLimitAmount: Long,
        val userInterest: Double
    )

    // DB 조회 결과 (조회의 결과로 가져온 모든 데이터)
    data class LoanReview(
        val userKey: String,
        val loanLimitAmount: Long,
        val loanInterest: Double
    )
}