package asymmetric.pual

import java.security.KeyPairGenerator

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
