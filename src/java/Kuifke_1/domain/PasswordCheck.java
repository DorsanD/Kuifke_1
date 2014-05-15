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
 * @author jx3
 */
public class PasswordCheck {

    CustomerBean customerBean;
    String pass;

    public PasswordCheck(CustomerBean customerBean, String password) {
        this.customerBean = customerBean;
        this.pass = password;
        pass = pass.replaceAll("y", "7");
    }

    public boolean check() {
        System.out.println("");
        if (customerBean.getPassword() != null) {

            // checked of de user ingelogged is

            //initialiseer de variabelen voor de check
            byte[] salt = customerBean.getSalt().getBytes();
            byte[] hash = customerBean.getPassword().getBytes();
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
