import org.junit.Test

/**
 * Created by andrenlars on 16/03/18.
 */
public class ECCKeyGeneratorTest extends GroovyTestCase {

    @Test
    void testGenerateKey() throws Exception {

        def keyPair = ECCKeyGenerator.generateKeys()

        assert keyPair.private.algorithm == "ECDSA"
    }
}