package sample.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sample.domain.domain.LoanReview

@Repository
interface LoanReviewRepository : JpaRepository<LoanReview, Long> {

    fun findByUserKey(userKey: String): LoanReview?

}