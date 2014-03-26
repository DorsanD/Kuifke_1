/*
 Dit is de salt generator 
 */
package Kuifke_1.domain;

import java.math.BigInteger;
import java.security.SecureRandom;
/**
 *
 * @author jx3
 */
public class PasswordSalts {

    public static final int SALT_LENGTH = 16;

    public static byte[] nextSalt() {
        SecureRandom random = new SecureRandom();
        /*
        byte[] salt = new byte[20];
        random.nextBytes(salt);
        System.out.println("nieuwe salt:" + salt.toString());
                */
        String sSalt = new BigInteger(130, random).toString(32);
        byte[] salt = sSalt.getBytes();
        System.out.println("nieuwe salt: "+sSalt);
        return salt;
    }


    

   
}
