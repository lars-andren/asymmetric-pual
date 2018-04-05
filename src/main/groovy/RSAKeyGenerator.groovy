import org.bouncycastle.crypto.generators.RSAKeyPairGenerator

/**
 * Created by andrenlars on 20/03/18.
 */
class RSAKeyGenerator {

    def static generateKeypair() {

        def rsaKeyPairGenerator = new RSAKeyPairGenerator();
        def keyPair = rsaKeyPairGenerator.generateKeyPair();
        keyPair.

        return keyPair
    }
}
