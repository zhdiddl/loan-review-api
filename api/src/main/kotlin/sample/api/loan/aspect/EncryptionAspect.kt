package sample.api.loan.aspect

import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import sample.api.loan.encrypt.EncryptComponent

@Aspect
@Component
class EncryptionAspect(
    private val encryptComponent: EncryptComponent
) {

    @Pointcut("@annotation(sample.api.loan.annotation.Encrypt)")
    fun encryptPointcut() {
    }

    @Pointcut("@annotation(sample.api.loan.annotation.Decrypt)")
    fun decryptPointcut() {
    }

    @Around("encryptPointcut()")
    fun encrypt(joinPoint: org.aspectj.lang.ProceedingJoinPoint): Any {
        val args = joinPoint.args.map { arg ->
            if (arg is String) encryptComponent.encryptString(arg) else arg
        }.toTypedArray()
        return joinPoint.proceed(args)
    }

    @Around("decryptPointcut()")
    fun decrypt(joinPoint: org.aspectj.lang.ProceedingJoinPoint): Any {
        val result = joinPoint.proceed()
        return if (result is String) encryptComponent.decryptString(result) else result
    }
}