/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuifke_1.domain;

import java.io.Serializable;

/**
 *
 * @author Dorsan
 */
public class ArtistBean implements Serializable {

    //initiatie van de variabelen.
    private int ArtistId;
    private String Artist_Name;
    private String Last_Name;
    private String First_Name;
    private String Gender;
    private String Email_Address;
    private String Username;
    private String Password;
    private String Language;
    private String salt;

    //getters en setters
    public int getArtistId() {
        return ArtistId;
    }

    public void setArtistId(int ArtistId) {
        this.ArtistId = ArtistId;
    }

    public String getArtist_Name() {
        return Artist_Name;
    }

    public void setArtist_Name(String Artist_Name) {
        this.Artist_Name = Artist_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String Email_Address) {
        this.Email_Address = Email_Address;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "ArtistBean{" + "ArtistId=" + ArtistId + ", Artist_Name=" + Artist_Name + ", Last_Name=" + Last_Name + ", First_Name=" + First_Name + ", Gender=" + Gender + ", Email_Address=" + Email_Address + ", Username=" + Username + ", Password=" + Password + ", Language=" + Language + ", salt=" + salt + '}';
    }
}
