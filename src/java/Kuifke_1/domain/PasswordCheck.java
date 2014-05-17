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
    //initiatie van de variabelen.
    CustomerBean customerBean;
    String pass;

    //constructor
    //de 'y' omzetten naar '7' omdat de hash verkeerd wordt omgezet.
    public PasswordCheck(CustomerBean customerBean, String password) {
        this.customerBean = customerBean;
        this.pass = password;
        pass = pass.replaceAll("y", "7");
    }

    //functie om te controleren of de login gegevens correct zijn.
    public boolean check() {
        System.out.println("");
        if (customerBean.getPassword() != null) {

            //initialiseer de variabelen voor de check
            byte[] salt = customerBean.getSalt().getBytes();
            byte[] hash = customerBean.getPassword().getBytes();
            char[] password = pass.toCharArray();
            String shash = new String(hash);
            System.out.println("ingegeven paswoord: " + pass + " wordt vergeleken met hash uit de database: " + shash);
            try {

                //kijkt of de paswoord hetzelfde is als de hash
                if (Password.matches(password, hash, salt)) {
                    System.out.println("paswoord correct");
                    pass = shash;
                    return true;
                } else {
                    System.out.println(" passwoord niet correct");
                    return false;




                }
            } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
                Logger.getLogger(PasswordCheck.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;

    }
}
