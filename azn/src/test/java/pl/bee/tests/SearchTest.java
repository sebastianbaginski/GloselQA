package pl.bee.tests;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bee.pages.HomePage;
import pl.bee.pages.SearchedPage;

public class SearchTest extends BaseTest {

    @Test
    public void searchProduct() {
        test = extentReports.createTest("Search Product Test");
        WebElement result = new HomePage(driver)
                .closeCookieBar()
                .searchPhrase("daktyle")
                .getElement();


        if (result.getText().contains("znaleziono") && new SearchedPage(driver).getUrl().contains("Szukaj")) {
            test.log(Status.PASS, "Search Product Test Passed");
        } else test.log(Status.FAIL, "Test failed");

        Assert.assertTrue(result.getText().contains("znaleziono"));
        Assert.assertTrue(new SearchedPage(driver).getUrl().contains("Szukaj"));
    }


}
