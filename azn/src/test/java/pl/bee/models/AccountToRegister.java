package pl.bee.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class AccountToRegister {


    int number = (int) Math.floor(Math.random() * 100) + (int) Math.floor(Math.random() * 100);

    private String firstName = "Damian";
    private String lastName = "Tester";
    private String phone = "234234234";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String timestamp = LocalDateTime.now().format(formatter);
    private String email = "damiantester" + timestamp  + "@arete33.pl";
    private String pass = "testerzy123";
    private String confPass = "testerzy123";

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getConfPass() {
        return confPass;
    }
}
