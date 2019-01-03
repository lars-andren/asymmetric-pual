package asymmetric.pual

import asymmetric.pual.RSAKeyGenerator
import org.junit.Test

/**
 * Created by andrenlars on 05/06/18.
 */
class RSAKeyGeneratorTest extends GroovyTestCase {

    @Test
    void testGenerateKey() throws Exception {

        def keyPair = RSAKeyGenerator.generateKeypair()

        expect:
            keyPair.private.algorithm == "RSA"
    }
}
