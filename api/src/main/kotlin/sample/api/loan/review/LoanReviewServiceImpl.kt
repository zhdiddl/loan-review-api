package sample.api.loan.review

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import sample.api.exception.CustomErrorCode
import sample.api.exception.CustomException
import sample.domain.domain.LoanReview
import sample.domain.repository.LoanReviewRepository

@Service
class LoanReviewServiceImpl(
    private val loanReviewRepository: LoanReviewRepository
) : LoanReviewService {
    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewOutputDto {
        return LoanReviewDto.LoanReviewOutputDto(
            userKey = userKey,
            loanResult = getLoanResult(userKey)?.toResponseDto()
                ?: throw CustomException(CustomErrorCode.RESULT_NOT_FOUND)
        )
    }

    @Cacheable(value = ["REVIEW"], key = "#userKey", cacheManager = "redisCacheManager")
    override fun getLoanResult(userKey: String) =
        loanReviewRepository.findByUserKey(userKey)

    private fun LoanReview.toResponseDto() =
        LoanReviewDto.LoanResult(
            userLimitAmount = this.loanLimitAmount,
            userInterest = this.loanInterest
        )
}