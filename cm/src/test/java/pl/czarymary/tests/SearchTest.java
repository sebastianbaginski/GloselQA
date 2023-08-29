package pl.czarymary.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.czarymary.pages.HomePage;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {

        String h2Result = new HomePage(driver)
                .searchPhrase("świeca")
                .getResult();

        Assert.assertEquals(h2Result, "Wyniki wyszukiwania: świeca");
    }

    @Test
    public void searchWithoutName() {

        String msg = new HomePage(driver)
                .searchPhrase("")
                .getMsg();

        Assert.assertEquals(msg, "Brak produktów");
    }
}
