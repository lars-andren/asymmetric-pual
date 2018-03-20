import org.bouncycastle.util.encoders.Hex

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class ECCUtil {

    public static byte[] encrypt(String message, PublicKey kU) {

        def messageBytes = message.getBytes()
        def encryptedMessage = new byte[0]

        try {
            Cipher c1 = Cipher.getInstance("ECIES")
            c1.init(Cipher.ENCRYPT_MODE, kU, new SecureRandom());
            encryptedMessage = c1.doFinal(messageBytes, 0, messageBytes.length)
        } catch (Exception e) {
            e.printStackTrace()
        }

        return encryptedMessage
    }

    public static byte[] decrypt(byte[] message, PrivateKey kR) {


        def decryptedMessage = new byte[0]

        try {
            Cipher c1 = Cipher.getInstance("ECIES")
            c1.init(Cipher.DECRYPT_MODE, kR, new SecureRandom())
            decryptedMessage = c1.doFinal(message, 0, message.length)
        } catch (Exception e) {
            e.printStackTrace()
        }

        return decryptedMessage
    }
}