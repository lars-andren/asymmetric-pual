import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrenlars on 16/03/18.
 */
public class ECCUtilTest extends GroovyTestCase {

    @Test
    public void testEncrypt() throws Exception {

        def message = "der lauf der zeit"

        def keyPair = ECCKeyGenerator.generateKey()
        ECCUtil.encrypt(message, keyPair.public)
    }

    public void testEncryptDecrypt() throws Exception {

        def message = "ohne dich"

        def keyPair = ECCKeyGenerator.generateKey()
        def secret = ECCUtil.encrypt(message, keyPair.public)

        def unsecret = ECCUtil.decrypt(secret, keyPair.private)

        assert message.getBytes() == unsecret
    }
}