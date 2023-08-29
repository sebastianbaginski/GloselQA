package pl.bee.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bee.models.MyAccounts;
import pl.bee.pages.HomePage;

public class LogInTest extends BaseTest {

    @Test
    public void logInWithCorrectlyEmail() {
        test = extentReports.createTest("Log In Test");
        MyAccounts mc = new MyAccounts();
        String h1 = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .logInWithCorrectlyData(mc)
                .getH1Text();

        if (h1.contains("MOJE KONTO")) {
            test.log(Status.PASS, "Log In Passed");
        } else test.log(Status.FAIL, "Test failed");

        Assert.assertEquals(h1, "MOJE KONTO");

    }

    @Test
    public void logInWithoutEmail() {
        test = extentReports.createTest("Log In Without Email");
        MyAccounts mc = new MyAccounts();
        mc.setEmail("");

        String error = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .logInWithoutEmail(mc)
                .getError();

        if (error.equals("Brak konta na podany adres e-mail")) {
            test.log(Status.PASS, "Test Log In without Email Passed");
        } else test.log(Status.FAIL, "Test failed");

        Assert.assertEquals(error, "Brak wymaganych danych logowania.");

    }

    @Test
    public void logInWithoutPass() {
        test = extentReports.createTest("Log In Without Password");
        MyAccounts mc = new MyAccounts();
        mc.setPassword("");

        String error = new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .logInWithoutEmail(mc)
                .getError();

        if (error.equals("Niepoprawne hasło")) {
            test.log(Status.PASS, "Test Log In without password Passed");
        } else test.log(Status.FAIL, "Test failed");

        Assert.assertEquals(error, "Brak wymaganych danych logowania.");

    }

}
