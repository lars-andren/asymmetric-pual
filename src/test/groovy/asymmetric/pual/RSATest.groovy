package asymmetric.pual

import asymmetric.pual.EncryptDecryptService
import asymmetric.pual.RSAKeyGenerator
import org.junit.Test

/**
 * Created by andrenlars on 16/03/18.
 */
public class RSATest extends GroovyTestCase {

    def rsaKeyGenerator = new RSAKeyGenerator()

    @Test
    public void testEncrypt() throws Exception {

        def message = "der lauf der zeit"

        def keyPair = rsaKeyGenerator.generateKeypair()
        EncryptDecryptService.encrypt(message, keyPair.public, "RSA")
    }

    @Test
    public void testEncryptDecrypt() throws Exception {

        def message = "ohne dich"

        def keyPair = rsaKeyGenerator.generateKeypair()
        def secret = EncryptDecryptService.encrypt(message, keyPair.public, "RSA")

        def unsecret = EncryptDecryptService.decrypt(secret, keyPair.private, "RSA")

        expect:
            message.getBytes() == unsecret
    }
}