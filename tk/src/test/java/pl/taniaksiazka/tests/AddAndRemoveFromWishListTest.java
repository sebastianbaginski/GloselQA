package pl.taniaksiazka.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.taniaksiazka.pages.HomePage;
import pl.taniaksiazka.pages.WishListPage;

public class AddAndRemoveFromWishListTest extends BaseTest {

    @Test
    public void addAndRemoveFromWishList() {

        WebElement resultAfterAdd = new HomePage(driver)
                .closeCookieBar()
                .hoverToCategory(driver)
                .chooseBooksCategory(driver)
                .addToWishList()
                .getH2();

        Assert.assertEquals(resultAfterAdd.getText(), "Dodano produkt do schowka!");

        WebElement resultAfterRemove = new WishListPage(driver)
                .deleteFromWishList();

        Assert.assertTrue(resultAfterRemove.isDisplayed());
    }
}
