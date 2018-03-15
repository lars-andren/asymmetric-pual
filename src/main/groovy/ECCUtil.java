
import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class ECCUtil {

    public static String encrypt(String message, PrivateKey kR) {

        byte[] messageBytes = message.getBytes();
        byte[] encryptedMessage = new byte[0];

        try {
            Cipher c1 = Cipher.getInstance("ECIES");
            c1.init(Cipher.ENCRYPT_MODE, kR, new SecureRandom());
            encryptedMessage = c1.doFinal(messageBytes, 0, messageBytes.length);
        } catch (Exception e) {
            e.printStackTrace(
            );
        }

        return new String(encryptedMessage);
    }

    public static String decrypt(String message, PublicKey kU) {

        byte[] messageBytes = message.getBytes();
        byte[] decryptedMessage = new byte[0];

        try {
            Cipher c1 = Cipher.getInstance("ECIES");
            c1.init(Cipher.DECRYPT_MODE, kU, new SecureRandom());
            decryptedMessage = c1.doFinal(messageBytes, 0, messageBytes.length);
        } catch (Exception e) {

        }

        return new String(decryptedMessage);
    }
}