import org.junit.Test

/**
 * Created by andrenlars on 05/06/18.
 */
class RSAKeyGeneratorTest extends GroovyTestCase {

    @Test
    void testGenerateKey() throws Exception {

        def keyPair = RSAKeyGenerator.generateKeypair()

        assert keyPair.private.algorithm == "RSA"
    }
}
