package com.example.cybersecurity;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding"; // Proper padding
    private static final byte[] SECRET_KEY = "MySecretKey12345".getBytes(); // Exactly 16 bytes

    public static String encrypt(String data) throws Exception {
        SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());

        // Debugging logs
        System.out.println("Data to Encrypt: " + data);
        System.out.println("Encrypted Data (Base64): " + Base64.getEncoder().encodeToString(encryptedBytes));

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData) throws Exception {
        SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);

        // Debugging logs
        System.out.println("Data to Decrypt (Base64): " + encryptedData);

        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        System.out.println("Decrypted Data: " + new String(decryptedBytes));
        return new String(decryptedBytes);
    }

}
