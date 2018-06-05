import org.bouncycastle.crypto.KeyGenerationParameters
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters

import java.security.KeyPairGenerator
import java.security.SecureRandom

/**
 * Created by andrenlars on 20/03/18.
 */
class RSAKeyGenerator {

    def static generateKeypair() {

        def rsaKeyPairGenerator = KeyPairGenerator.getInstance("RSA")
        rsaKeyPairGenerator.initialize(1024)
        def keyPair = rsaKeyPairGenerator.generateKeyPair()

        return keyPair
    }
}
