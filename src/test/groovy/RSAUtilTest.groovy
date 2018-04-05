import org.junit.Test

/**
 * Created by andrenlars on 16/03/18.
 */
public class RSAUtilTest extends GroovyTestCase {

    def rsaKeyGenerator = new RSAKeyGenerator()

    @Test
    public void testEncrypt() throws Exception {

        def message = "der lauf der zeit"

        def keyPair = rsaKeyGenerator.generateKeypair()
        EncryptDecryptUtil.encrypt(message, keyPair.public, "RSA")
    }

    @Test
    public void testEncryptDecrypt() throws Exception {

        def message = "ohne dich"

        def keyPair = rsaKeyGenerator.generateKeypair()
        def secret = EncryptDecryptUtil.encrypt(message, keyPair.public, "RSA")

        def unsecret = EncryptDecryptUtil.decrypt(secret, keyPair.private, "RSA")

        assert message.getBytes() == unsecret
    }
}