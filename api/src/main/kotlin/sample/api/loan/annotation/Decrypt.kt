package sample.api.loan.annotation

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FUNCTION

@Target(FUNCTION)
@Retention(RUNTIME)
annotation class Decrypt {
}