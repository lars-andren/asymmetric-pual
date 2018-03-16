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

    @Test
    public void testDecrypt() throws Exception {

    }

    public void testEncryptDecrypt() throws Exception {

    }
}