package com.tjcloud.platform.utils.service;

import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;

public class SecurityUtil {
    protected static final org.apache.commons.logging.Log log = LogFactory.getLog(SecurityUtil.class);
    public static final String USER_PASSWORD_SALT_PREFIX = "TShark-PWD-Salt:2011";
    private static PasswordEncoder passwordEncoder = new ShaPasswordEncoder();
    private static final String KEY_ALGORITHM = "DESede";
    private static final String DEFAULT_CIPHER_ALGORITHM = "DESede/ECB/ISO10126Padding";

    public SecurityUtil() {
    }

    public static String encodePassword(String password, String salt) {
        return passwordEncoder.encodePassword(password,
                "TShark-PWD-Salt:2011" + salt);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("加密前数据: string:"
                + encodePassword("admin", "admin"));
    }

    public static byte[] genSecretKey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("DESede");
        kg.init(168);
        SecretKey secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }

    public static Key toKey(byte[] key) throws Exception {
        DESedeKeySpec dks = new DESedeKeySpec(key);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = skf.generateSecret(dks);

        return secretKey;
    }


    public static byte[] encrypt(byte[] data, Key key) throws Exception {
        return encrypt(data, key, "DESede/ECB/ISO10126Padding");
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        return encrypt(data, key, "DESede/ECB/ISO10126Padding");
    }

    public static byte[] encrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
        Key k = toKey(key);
        return encrypt(data, k, cipherAlgorithm);
    }

    public static byte[] encrypt(byte[] data, Key key, String cipherAlgorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        cipher.init(1, key);

        return cipher.doFinal(data);
    }


    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        return decrypt(data, key, "DESede/ECB/ISO10126Padding");
    }


    public static byte[] decrypt(byte[] data, Key key) throws Exception {
        return decrypt(data, key, "DESede/ECB/ISO10126Padding");
    }


    public static byte[] decrypt(byte[] data, byte[] key, String cipherAlgorithm) throws Exception {
        Key k = toKey(key);
        return decrypt(data, k, cipherAlgorithm);
    }


    public static byte[] decrypt(byte[] data, Key key, String cipherAlgorithm)
            throws Exception {

        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        cipher.init(2, key);
        return cipher.doFinal(data);
    }


    private static String showByteArray(byte[] data) {

        if (null == data) {
            return null;
        }

        StringBuilder sb = new StringBuilder("{");
        for (byte b : data) {
            sb.append(b).append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

}