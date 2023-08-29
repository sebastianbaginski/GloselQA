package pl.taniaksiazka.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.taniaksiazka.pages.HomePage;

public class CustomerContactTest extends BaseTest {

    @Test
    public void customerContact() {
        String msg = "Sprawdzanie formularza przez IT";
        boolean checkInfo = new HomePage(driver)
                .closeCookieBar()
                .goToCustomerContactPage()
                .fillData("Damian Tester",
                        "damian.mucus+test1@arete33.pl",
                        "123456789",
                        msg)
                .isResultTextExist();

        Assert.assertTrue(checkInfo);

    }
}
