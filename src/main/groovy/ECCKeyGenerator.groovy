import org.bouncycastle.jce.ECNamedCurveTable
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.jce.spec.ECParameterSpec

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.Security

class ECCKeyGenerator {

    def static KeyPair generateKeypair() {

        Security.addProvider(new BouncyCastleProvider())

        def keypair = null;

        ECParameterSpec ecParameterSpec = ECNamedCurveTable.getParameterSpec("prime192v1");

        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDSA", "BC")
            generator.initialize(ecParameterSpec)
            keypair = generator.generateKeyPair()
        } catch (Exception e) {
            e.printStackTrace()
        }

        return keypair
    }
}
