package pl.czarymary.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.czarymary.models.RegisterCustomer;
import pl.czarymary.pages.HomePage;

public class RegisterUserTest extends BaseTest {

    @Test
    public void registerUser() {

        RegisterCustomer registerCustomer = new RegisterCustomer();

        String msg = new HomePage(driver)
                .goToLogInPage()
                .registerUser(registerCustomer)
                .getResult();

        Assert.assertEquals(msg, "Twoje konto");

    }

    @Test
    public void registerUserWithoutPass() {
        RegisterCustomer registerCustomer = new RegisterCustomer();
        registerCustomer.setPassword("");

        WebElement error = new HomePage(driver)
                .goToLogInPage()
                .registerUserWithInvalidData(registerCustomer);

        Assert.assertEquals(error.getText(), "Wpisz min. 4 znaki");
    }

    @Test
    public void registerUserWithoutEmail() {
        RegisterCustomer registerCustomer = new RegisterCustomer();
        registerCustomer.setEmail("");

        WebElement error = new HomePage(driver)
                .goToLogInPage()
                .registerUserWithInvalidData(registerCustomer);

        Assert.assertEquals(error.getText(), "Wprowadź adres e-mail");
    }

    @Test
    public void registerUserWithoutNumber() {
        RegisterCustomer registerCustomer = new RegisterCustomer();
        registerCustomer.setPhone("");

        WebElement error = new HomePage(driver)
                .goToLogInPage()
                .registerUserWithInvalidData(registerCustomer);

        Assert.assertEquals(error.getText(), "Wpisz poprawny 9-cyfrowy numer telefonu");
    }
}