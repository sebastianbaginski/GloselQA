package pl.taniaksiazka.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.taniaksiazka.models.RegisterCustomer;
import pl.taniaksiazka.pages.HomePage;
import pl.taniaksiazka.pages.LogInPage;

public class RegisterUserTest extends BaseTest {

    @Test
    public void registerUser() {

        RegisterCustomer registerCustomer = new RegisterCustomer();

        String textOfUserBox = new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .registerUser(registerCustomer, "")
                .checkUserBox();

        Assert.assertTrue(textOfUserBox.contains("Twoje konto"));
    }

    @Test
    public void registerWithExistingEmail() {
        RegisterCustomer registerCustomer = new RegisterCustomer();
        registerCustomer.setEmail("damian.mucus+test1@arete33.pl");

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .registerUser(registerCustomer, "");

        String registerError = new LogInPage(driver)
                .registerError();

        Assert.assertEquals(registerError, "Konto o podanym adresie już istnieje");

    }

    @Test
    public void registerWithoutAccept() {
        RegisterCustomer registerCustomer = new RegisterCustomer();

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .registerUser(registerCustomer, "Don't accept");

        String registerError = new LogInPage(driver)
                .registerError();

        Assert.assertEquals(registerError, "To pole jest wymagane");

    }

    @Test
    public void registerWithoutPassword() {
        RegisterCustomer registerCustomer = new RegisterCustomer();
        registerCustomer.setPassword("");

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .registerUser(registerCustomer, "");

        String registerError = new LogInPage(driver)
                .registerError();

        Assert.assertEquals(registerError, "Wpisz min. 4 znaki");

    }

}
