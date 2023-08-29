package pl.czarymary.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.czarymary.pages.HomePage;

public class WishListTest extends BaseTest {

    @Test
    public void wishListTest() {

        WebElement result = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .goToHomePage()
                .chooseProduct()
                .addToWishList()
                .deleteProductFromWishList();

          Assert.assertTrue(result.getText().contains("Usunięto produkt ze schowka!"));
    }
}
