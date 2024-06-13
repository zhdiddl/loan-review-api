package sample.api.loan.request

import org.springframework.stereotype.Service
import sample.domain.domain.UserInfo

@Service
interface LoanRequestService {
    fun loanRequestMain(loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestOutputDto

    fun saveUserInfo(userInfoDto: UserInfoDto): UserInfo

    fun loanRequestReview(userInfoDto: UserInfoDto)
}