package pl.bee.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bee.pages.HomePage;

public class CustomerContactTest extends BaseTest {


    @Test
    public void contactTest() {
        test = extentReports.createTest("Contact with customer Test");
        String msg = "Sprawdzanie formularza przez IT";

        boolean resultIsDisplayed = new HomePage(driver)
                .closeCookieBar()
                .goToContactPage()
                .putData("Damian Tester", "damian.mucus+test1@arete33.pl", "123456789", msg)
                .isDisplayed();

        if (resultIsDisplayed) {
            test.log(Status.PASS, "Contact with customer Test Passed");
        } else test.log(Status.FAIL, "Test failed");

        Assert.assertTrue(resultIsDisplayed);

    }

}
