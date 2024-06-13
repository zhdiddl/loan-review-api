package sample.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sample.domain.domain.UserInfo

@Repository
interface UserInfoRepository : JpaRepository<UserInfo, Long> {
    fun findByUserKey(userKey: String): UserInfo
}