package Kuifke_1.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Noel Vaes
 */
public class CustomerBean implements Serializable {
    //initiatie van de variabelen
    private int CustomerId;
    private Date Date;
    private String Last_Name;
    private String First_Name;
    private String Gender;
    private String Email_Address;
    private String Username;
    private String Password;
    private String Language;
    private String salt;
    private String newUsername;
    private int Credits;

    //getters en setters
    public int getCredits() {
        return Credits;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    
    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
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

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String Email_Address) {
        this.Email_Address = Email_Address;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getId() {
        return CustomerId;
    }

    public String getName() {
        return Last_Name;
    }

    public void setName(String name) {
        this.Last_Name = name;
    }

    public String getEmail() {
        return Email_Address;
    }

    public void setEmail(String email) {
        this.Email_Address = email;
    }

    public void setId(int customerId) {
        this.CustomerId = customerId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    public String getFirstname() {
        return First_Name;
    }

    public void setFirstname(String firstname) {
        this.First_Name = firstname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        this.Language = language;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    @Override
    public String toString() {
        return "WebsiteBean{" + "id=" + CustomerId + ", date=" + Date + ", name=" + Last_Name + ", firstname=" + First_Name + ", email=" + Email_Address + ", gender=" + Gender + ", username=" + Username + ", password=" + Password + ", language=" + Language + '}';
    }
}
