package asymmetric.pual

import org.bouncycastle.jce.provider.BouncyCastleProvider

import java.security.KeyPairGenerator
import java.security.Security

/**
 * Created by andrenlars on 20/03/18.
 */
class RSAKeyGenerator {

    def static generateKeypair() {

        Security.addProvider(new BouncyCastleProvider())

        def rsaKeyPairGenerator = KeyPairGenerator.getInstance("RSA")
        rsaKeyPairGenerator.initialize(1024)
        def keyPair = rsaKeyPairGenerator.generateKeyPair()

        return keyPair
    }
}
