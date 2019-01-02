import asymmetric.pual.ECCKeyGenerator
import asymmetric.pual.EncryptDecryptService
import org.junit.Test

/**
 * Created by andrenlars on 16/03/18.
 */
public class ECCTest extends GroovyTestCase {

    def eccKeyGenerator = new ECCKeyGenerator()

    @Test
    public void testEncrypt() throws Exception {

        def message = "der lauf der zeit"

        def keyPair = eccKeyGenerator.generateKeypair()
        EncryptDecryptService.encrypt(message, keyPair.public, "ECIES")
    }

    @Test
    public void testEncryptDecrypt() throws Exception {

        def message = "ohne dich"

        def keyPair = eccKeyGenerator.generateKeypair()
        def secret = EncryptDecryptService.encrypt(message, keyPair.public, "ECIES")

        def unsecret = EncryptDecryptService.decrypt(secret, keyPair.private, "ECIES")

        expect:
            message.getBytes() == unsecret
    }
}