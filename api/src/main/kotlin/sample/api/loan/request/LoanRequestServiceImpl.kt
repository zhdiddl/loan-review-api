package sample.api.loan.request

import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service
import sample.api.loan.GenerateKey
import sample.api.loan.annotation.Encrypt
import sample.api.loan.encrypt.EncryptComponent
import sample.domain.repository.UserInfoRepository
import sample.kafka.enum.KafkaTopic
import sample.kafka.producer.LoanRequestSender

@Service
@ComponentScan(basePackages = ["sample.kafka", "sample.api", "sample.domain"])
class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent,
    private val loanRequestSender: LoanRequestSender
) : LoanRequestService {

    @Encrypt
    override fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestOutputDto {
        val userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
            encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        val userInfoDto = loanRequestInputDto.toUserInfoDto(userKey)

        saveUserInfo(userInfoDto)

        loanRequestReview(userInfoDto)

        return LoanRequestDto.LoanRequestOutputDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())

    override fun loanRequestReview(userInfoDto: UserInfoDto) {
        loanRequestSender.sendMessage(
            KafkaTopic.LOAN_REQUEST,
            userInfoDto.toLoanRequestKafkaDto()
        )
    }
}