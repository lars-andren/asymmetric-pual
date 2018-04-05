import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrenlars on 16/03/18.
 */
public class ECCUtilTest extends GroovyTestCase {

    def eccKeyGenerator = new ECCKeyGenerator()

    @Test
    public void testEncrypt() throws Exception {

        def message = "der lauf der zeit"

        def keyPair = eccKeyGenerator.generateKeypair()
        EncryptDecryptUtil.encrypt(message, keyPair.public, "ECIES")
    }

    @Test
    public void testEncryptDecrypt() throws Exception {

        def message = "ohne dich"

        def keyPair = eccKeyGenerator.generateKeypair()
        def secret = EncryptDecryptUtil.encrypt(message, keyPair.public, "ECIES")

        def unsecret = EncryptDecryptUtil.decrypt(secret, keyPair.private, "ECIES")

        assert message.getBytes() == unsecret
    }
}