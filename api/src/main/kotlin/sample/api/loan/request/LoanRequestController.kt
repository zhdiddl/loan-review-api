package sample.api.loan.request

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class LoanRequestController(
    private val loanRequestServiceImpl: LoanRequestServiceImpl
) {

    @Operation(summary = "대출 신청을 보내고 결과 값으로 유저키 반환")
    @PostMapping("/request")
    fun loanRequest(
        @RequestBody loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): ResponseEntity<LoanRequestDto.LoanRequestOutputDto> {
        return ResponseEntity.ok(
            loanRequestServiceImpl.loanRequestMain(loanRequestInputDto)
        )
    }
}