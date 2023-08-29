package pl.czarymary.models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterCustomer {

    int number = (int) Math.floor(Math.random() * 100)*(int) Math.floor(Math.random() * 100);

    private final String firstName = "Damian";
    private final String lastName = "Tester";
    private String phone = "234234234";

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String timestamp = LocalDateTime.now().format(formatter);
    private String email = "damiantester" + timestamp  + "@tel.czarymary.pl";
    private String password = "testerzy123";
    private final String confirmPassword = "testerzy123";

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


}
