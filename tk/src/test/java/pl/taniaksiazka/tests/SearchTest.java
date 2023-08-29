package pl.taniaksiazka.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.taniaksiazka.pages.HomePage;

public class SearchTest extends BaseTest {

    @Test
    public void searchProduct() {
        WebElement result = new HomePage(driver)
                .closeCookieBar()
                .searchProduct("pucio")
                .getResult();

        Assert.assertEquals(result.getText(), "Pucio - książki, zabawki, puzzle, gry");

    }

    @Test
    public void searchEmptyString() {
        WebElement result = new HomePage(driver)
                .closeCookieBar()
                .searchProduct("")
                .getNoResult();

        Assert.assertTrue(result.getText().contains("Brak produktów!"));

    }
}