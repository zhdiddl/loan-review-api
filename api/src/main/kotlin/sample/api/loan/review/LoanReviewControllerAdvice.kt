package sample.api.loan.review

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import sample.api.exception.CustomException
import sample.api.exception.ErrorResponse

@RestControllerAdvice(basePackageClasses = [LoanReviewController::class]) // 특정 클래스에서만 에러 처리
class LoanReviewControllerAdvice {

    @ExceptionHandler(CustomException::class)
    fun customExceptionHandler(customException: CustomException) =
        ErrorResponse(customException).toResponseEntity()
}