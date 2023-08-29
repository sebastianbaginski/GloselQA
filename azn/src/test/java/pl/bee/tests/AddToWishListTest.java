package pl.bee.tests;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.bee.pages.HomePage;
import pl.bee.pages.WishListPage;

public class AddToWishListTest extends BaseTest {

    @Test
    public void addToWishListAndRemove() {
        test = extentReports.createTest("WishList Test");

        WebElement result = new HomePage(driver)
                .closeCookieBar()
                .chooseItem()
                .addProductToWishList()
                .getResult();

        Assert.assertTrue(result.isDisplayed());


        if (result.isDisplayed()) {
            test.log(Status.PASS, "Add to WishList passed");
        } else test.log(Status.FAIL, "Test failed");

        boolean removeResult = new WishListPage(driver)
                .removeItems();


        if (removeResult) {
            test.log(Status.PASS, "Remove from WishList passed");
        } else test.log(Status.FAIL, "Test failed");

        Assert.assertTrue(removeResult);
    }

}
