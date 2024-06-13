package sample.api.test

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class TestController (
    private val testService: TestService
){
    @Operation(summary = "userKey를 통해서 유저 정보 찾기")
    @GetMapping("/test/get/{userKey}")
    fun test(
        @PathVariable userKey: String
    ): TestDto.UserInfoDto = testService.testGetService(userKey)
}