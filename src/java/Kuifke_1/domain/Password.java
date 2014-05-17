/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.domain;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author jx3
 */
public class Password {
    //initiatie van de variabelen.
    public static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    public static final int ITERATION_COUNT = 8192;
    public static final int KEY_SIZE = 160;
    byte[] salt;
    byte[] hash;

    public Password(String pw) throws GeneralSecurityException {
        System.out.println("paswoord wordt geencrypted");
        char[] password = pw.toCharArray();

        //maak een nieuwe salt aan
        salt = PasswordSalts.nextSalt();

        //hash het paswoord
        hash = hashPassword(password, salt);
        System.out.println("niewe hash aangemaakt: " + (new String(hash)));

    }

    public Password() throws GeneralSecurityException {
    }

    public static byte[] hashPassword(char[] password, byte[] salt)
            throws GeneralSecurityException {
        return hashPassword(password, salt, ITERATION_COUNT, KEY_SIZE);
    }

    public static byte[] hashPassword(char[] password, byte[] salt,
            int iterationCount, int keySize) throws GeneralSecurityException {

        PBEKeySpec spec = new PBEKeySpec(password, salt, iterationCount, keySize);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        return factory.generateSecret(spec).getEncoded();
    }

    public static boolean matches(char[] password, byte[] passwordHash,
            byte[] salt) throws GeneralSecurityException, UnsupportedEncodingException {
        return matches(password, passwordHash, salt, ITERATION_COUNT, KEY_SIZE);
    }

    public static boolean matches(char[] password, byte[] passwordHash,
            byte[] salt, int iterationCount, int keySize)
            throws GeneralSecurityException, UnsupportedEncodingException {

        //incrypteren van de passwoord
        byte[] newHash = hashPassword(password, salt, ITERATION_COUNT, KEY_SIZE);
        String omgezet = new String(newHash);
        System.out.println("omgezette hash: " + omgezet);

        return Arrays.equals(passwordHash, newHash);
    }

    //getters
    public String getSalt() throws UnsupportedEncodingException {
        String sSalt = new String(salt);
        return sSalt;
    }

    public String getHash() throws UnsupportedEncodingException {
        String sHash = new String(hash);
        return sHash;
    }
}
