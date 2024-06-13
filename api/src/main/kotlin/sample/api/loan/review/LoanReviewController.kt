package sample.api.loan.review

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class LoanReviewController(
    private val loanReviewServiceImpl: LoanReviewServiceImpl
) {

    @Operation(summary = "유저키를 보내고 대출 신청 결과 데이터를 반환")
    @GetMapping("review/{userKey}")
    fun getReviewData(
        @PathVariable userKey: String
    ): ResponseEntity<LoanReviewDto.LoanReviewOutputDto> {
        return ResponseEntity.ok(loanReviewServiceImpl.loanReviewMain(userKey))
    }
}