package Kuifke_1.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Noel Vaes
 */
public class WebsiteBean implements Serializable {
    private int CustomerId;
    private Date Date;
    private String Last_Name;
    private String First_Name;
    private String Gender;
    private String Email_Address;
    private String Username;
    private String Password;
    private String Language;
    private int[] answers = new int[1];


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
    
     public int[] getAnswers() {
        return answers;
    }

    public void setAnswers(int[] answers) {
        this.answers = answers;
    }

    public int getAnswer(int index) {
        return answers[index];
    }
    
    public void setAnswer(int index, int answer) {
        answers[index] = answer;
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
        return "WebsiteBean{" + "id=" + CustomerId + ", date=" + Date + ", name="  + Last_Name + ", firstname=" +  First_Name + ", email=" + Email_Address  + ", gender=" + Gender + ", username=" + Username + ", password=" + Password + ", language=" + Language + '}';
    }

}
