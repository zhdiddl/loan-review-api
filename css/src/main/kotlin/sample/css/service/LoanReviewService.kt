package sample.css.service

import org.springframework.stereotype.Service
import sample.css.dto.LoanRequestDto
import sample.css.dto.LoanResultDto

@Service
class LoanReviewService {
    fun loanReview(
        loanRequestDto: LoanRequestDto.RequestInputDto
    ): LoanResultDto.ResponseDto {
        // 가상 CB사 비즈니스 로직
        return when {
            loanRequestDto.userIncomeAmount < 0 -> throw RuntimeException("Invalid userIncomeAmount parameter")
            loanRequestDto.userIncomeAmount < 10_000_000 -> LoanResultDto.ResponseDto(
                loanRequestDto.userKey,
                10_000_000,
                0.0
            )

            loanRequestDto.userIncomeAmount < 20_000_000 -> LoanResultDto.ResponseDto(
                loanRequestDto.userKey,
                20_000_000,
                10.0
            )

            loanRequestDto.userIncomeAmount < 30_000_000 -> LoanResultDto.ResponseDto(
                loanRequestDto.userKey,
                30_000_000,
                9.0
            )

            loanRequestDto.userIncomeAmount < 40_000_000 -> LoanResultDto.ResponseDto(
                loanRequestDto.userKey,
                40_000_000,
                8.0
            )

            loanRequestDto.userIncomeAmount < 50_000_000 -> LoanResultDto.ResponseDto(
                loanRequestDto.userKey,
                50_000_000,
                7.0
            )

            loanRequestDto.userIncomeAmount >= 50_000_000 -> LoanResultDto.ResponseDto(
                loanRequestDto.userKey,
                60_000_000,
                6.0
            )

            else -> throw RuntimeException("Invalid userIncomeAmount parameter")
        }
    }
}