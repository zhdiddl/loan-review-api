package sample.api.exception

import org.springframework.http.ResponseEntity
import java.time.LocalDateTime

class ErrorResponse(
    private val customException: CustomException
) {
    fun toResponseEntity(): ResponseEntity<ErrorResponseDto> {
        return ResponseEntity // DTO를 Entity로 변환해서 반환
            .status(customException.customErrorCode.statusCode) // HTTP 상태코드 설정
            .body(
                ErrorResponseDto(
                    errorCode = customException.customErrorCode.errorCode, // 에러 코드 설정
                    errorMessage = customException.customErrorCode.errorMessage // 에러 메시지 설정
                )
            )
    }

    data class ErrorResponseDto(
        val errorCode: String,
        val errorMessage: String
    ) {
        val timeStamp = LocalDateTime.now()
    }
}