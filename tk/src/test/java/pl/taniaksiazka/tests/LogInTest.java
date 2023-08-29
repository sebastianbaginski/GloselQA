package pl.taniaksiazka.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.taniaksiazka.pages.HomePage;

public class LogInTest extends BaseTest {


    @Test
    public void logIn() {

        boolean h3 = new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123")
                .isH3Displayed();

        Assert.assertTrue(h3);

    }

    @Test
    public void logInWithoutPassword() {

        String errorText = new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logInWithoutPassword("damian.mucus+test1@arete33.pl", "");

        Assert.assertEquals(errorText, "Brak wymaganych danych logowania.");

    }


}
