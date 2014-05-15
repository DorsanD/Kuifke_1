/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.domain;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dorsan
 */
public class ArtistPasswordCheck {

    ArtistBean artistBean;
    String pass;

    public ArtistPasswordCheck(ArtistBean artistBean, String password) {
        this.artistBean = artistBean;
        this.pass = password;
        pass = pass.replaceAll("y", "7");
    }

    public boolean check() {
        System.out.println("");
        if (artistBean.getPassword() != null) {

            // checked of de user ingelogged is

            //initialiseer de variabelen voor de check
            byte[] salt = artistBean.getSalt().getBytes();
            byte[] hash = artistBean.getPassword().getBytes();
            char[] password = pass.toCharArray();
            String shash = new String(hash);
            System.out.println("ingegeven paswoord: " + pass + " wordt vergeleken met hash uit de database: " + shash);
            try {
                // match de paswoorden

                if (Password.matches(password, hash, salt)) {
                    //als de hashes matchen
                    System.out.println("paswoord matched");

                    //gehashte paswoord als paswoord instellen
                    pass = shash;
                    return true;
                } else {
                    //als de hashes niet matchen
                    System.out.println("geen passwoord match");
                    return false;




                }
            } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
                Logger.getLogger(PasswordCheck.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;

    }
}
