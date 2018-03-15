import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class ECCKeyGenerator {

    public static KeyPair generateKey() {

        KeyPair keypair = null;

        Random rand = new SecureRandom();
        BigInteger bigint1 = new BigInteger(32, rand);
        BigInteger bigint2 = new BigInteger(32, rand);
        BigInteger bigint3 = new BigInteger(32, rand);
        BigInteger bigint4 = new BigInteger(32, rand);

        byte[] randomBytes  = new byte[32];
        rand.nextBytes(randomBytes);

        ECCurve curve = new ECCurve.Fp(bigint1, bigint2, bigint3);

        ECParameterSpec ecParameterSpec = new ECParameterSpec(
                curve,
                curve.decodePoint(randomBytes),
                bigint4);

        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDSA", "BC");
            generator.initialize(ecParameterSpec);
            keypair = generator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return keypair;
    }
}
