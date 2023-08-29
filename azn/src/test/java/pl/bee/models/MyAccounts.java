package pl.bee.models;

public class MyAccounts {

    private String email = "damian.mucus+test1@arete33.pl";
    private String password = "testerzy123";

    public String getLogIn() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}