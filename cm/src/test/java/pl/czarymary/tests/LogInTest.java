package pl.czarymary.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.czarymary.pages.HomePage;
import pl.czarymary.pages.LogInPage;

public class LogInTest extends BaseTest {

    @Test
    public void logIn() {

        String msg = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .getResult();

        Assert.assertEquals(msg, "Twoje konto");

    }

    @Test
    public void logInWithoutPassword() {

        new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "");

        String error = new LogInPage(driver)
                .getError();

        Assert.assertEquals(error, "Brak wymaganych danych logowania.");

    }
}
