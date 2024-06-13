package sample.api.loan.encrypt

import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class EncryptComponent {
    companion object {
        private const val secretKey = "12345678901234561234567890123456"
    }

    private val encoder = Base64.getEncoder()
    private val decoder = Base64.getDecoder()

    // 입력한 문자열을 AES 알고리즘으로 암호화
    fun encryptString(encryptString: String): String {
        val encryptedString = cipherPkcs5(Cipher.ENCRYPT_MODE, secretKey)
            .doFinal(encryptString.toByteArray(Charsets.UTF_8))

        return String(encoder.encode(encryptedString))
    }

    // 입력한 문자열을 AES 알고리즘으로 복호화
    fun decryptString(decryptString: String): String {
        val byteString = decoder.decode(decryptString.toByteArray(Charsets.UTF_8))

        return String(cipherPkcs5(Cipher.DECRYPT_MODE, secretKey).doFinal(byteString))
    }

    // AES 알고리즘을 사용해서 암호화 및 복호화를 수행할 Cipher 객체 초기화
    fun cipherPkcs5(opMode: Int, secretKey: String): Cipher {
        val c = Cipher.getInstance("AES/CBC/PKCS5Padding")
        val sk = SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), "AES")
        val iv = IvParameterSpec(secretKey.substring(0, 16).toByteArray(Charsets.UTF_8))
        c.init(opMode, sk, iv)
        return c
    }

}