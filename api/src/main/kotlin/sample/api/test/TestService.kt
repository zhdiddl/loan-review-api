package sample.api.test

import org.springframework.stereotype.Service
import sample.domain.domain.UserInfo
import sample.domain.repository.UserInfoRepository

@Service
class TestService(
    private val userInfoRepository: UserInfoRepository
) {
    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey).toDto()

    fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistration, userName, userIncomeAmount)
}