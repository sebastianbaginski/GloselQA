package pl.bee.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bee.models.AccountToRegister;
import pl.bee.pages.HomePage;


public class RegisterTest extends BaseTest {


    @Test
    public void registerUser() {
        test = extentReports.createTest("Register User");
        AccountToRegister accountToRegister = new AccountToRegister();
        String name = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUser(accountToRegister)
                .getString();

        if (name.equals("MOJE KONTO")) {
            test.log(Status.PASS, "Register user Test passed");
        } else test.log(Status.FAIL, "Register user Test Test failed");

        Assert.assertEquals(name, "MOJE KONTO");
    }

    @Test
    public void registerUserWithExistingEmail() {
        test = extentReports.createTest("Register User with Existing E-mail");
        AccountToRegister accountToRegister = new AccountToRegister();
        accountToRegister.setEmail("damian.mucus+test1@arete33.pl");

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUserWithExistingEmail(accountToRegister)
                .getError();

        if (errorText.equals("Konto o podanym adresie już istnieje")) {
            test.log(Status.PASS, "Register User with Existing E-mail Test passed");
        } else test.log(Status.FAIL, "Register User with Existing E-mail Test failed");

        Assert.assertEquals(errorText, "Konto o podanym adresie już istnieje");
    }


    @Test
    public void registerUserWithoutEmail() {
        test = extentReports.createTest("Register user without Email");
        AccountToRegister accountToRegister = new AccountToRegister();
        accountToRegister.setEmail("");

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUserWithExistingEmail(accountToRegister)
                .getError();

        if (errorText.equals("Wprowadź adres e-mail")) {
            test.log(Status.PASS, "Register User without Email Test passed");
        } else test.log(Status.FAIL, "Register User without Email Test failed");

        Assert.assertEquals(errorText, "Wprowadź adres e-mail");
    }


    @Test
    public void registerUserWithoutName() {
        test = extentReports.createTest("Register user without name");
        AccountToRegister accountToRegister = new AccountToRegister();
        accountToRegister.setFirstName("");

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUserWithExistingEmail(accountToRegister)
                .getError();

        if (errorText.equals("Wprowadź minimum 2 znaki")) {
            test.log(Status.PASS, "Register User without name Test passed");
        } else test.log(Status.FAIL, "Register User without name Test failed");

        Assert.assertEquals(errorText, "Wprowadź minimum 2 znaki");
    }

    @Test
    public void registerUserWithoutLastName() {
        test = extentReports.createTest("Register user without Last Name");
        AccountToRegister accountToRegister = new AccountToRegister();
        accountToRegister.setLastName("");

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUserWithExistingEmail(accountToRegister)
                .getError();

        if (errorText.equals("Wprowadź minimum 2 znaki")) {
            test.log(Status.PASS, "Register User without Last name Test passed");
        } else test.log(Status.FAIL, "Register User without Last name Test failed");

        Assert.assertEquals(errorText, "Wprowadź minimum 2 znaki");
    }


    @Test
    public void registerUserWithoutNumber() {
        test = extentReports.createTest("Register user without number");
        AccountToRegister accountToRegister = new AccountToRegister();
        accountToRegister.setPhone("");

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUserWithExistingEmail(accountToRegister)
                .getError();

        if (errorText.equals("Wpisz poprawny 9-cyfrowy numer telefonu")) {
            test.log(Status.PASS, "Register User without number Test passed");
        } else test.log(Status.FAIL, "Register User without number Test failed");

        Assert.assertEquals(errorText, "Wpisz poprawny 9-cyfrowy numer telefonu");
    }

    @Test
    public void registerUserWithoutPassword() {
        test = extentReports.createTest("Register user without password");
        AccountToRegister accountToRegister = new AccountToRegister();
        accountToRegister.setPass("");

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUserWithExistingEmail(accountToRegister)
                .getError();

        if (errorText.equals("Wpisz min. 4 znaki")) {
            test.log(Status.PASS, "Register user without password Test passed");
        } else test.log(Status.FAIL, "Register user without password Test failed");

        Assert.assertEquals(errorText, "Wpisz min. 4 znaki");
    }


    @Test
    public void registerUserWithoutAccept() {
        test = extentReports.createTest("Register user without statute accept");
        AccountToRegister accountToRegister = new AccountToRegister();
        accountToRegister.setFirstName("Adam");

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUserWithExistingEmail(accountToRegister)
                .getError();

        if (errorText.equals("Wyraź zgodę na przetwarzanie")) {
            test.log(Status.PASS, "Register User without statute accept Test passed");
        } else test.log(Status.FAIL, "Register User without statute accept Test failed");

        Assert.assertEquals(errorText, "Wyraź zgodę na przetwarzanie");

    }


    @Test
    public void registerUserWithShortNumberPhone(){

        AccountToRegister accountToRegister = new AccountToRegister();
        accountToRegister.setPhone("3452");

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .registerUserWithExistingEmail(accountToRegister)
                .getError();

        Assert.assertEquals(errorText, "Wpisz poprawny numer telefonu");


    }

}
