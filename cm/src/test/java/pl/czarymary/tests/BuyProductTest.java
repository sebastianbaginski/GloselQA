package pl.czarymary.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pl.czarymary.pages.HomePage;
import pl.czarymary.pages.LoggedPage;

public class BuyProductTest extends BaseTest {

    @Test
    public void buyProductPoint() throws InterruptedException {
        WebElement h2 = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .goToHomePage()
                .chooseProduct()
                .addToCartPage()
                .goToCartPage()
                .chooseShip(0)
                .goToAddressDataPage()
                .searchPoint()
                .goToSuccessPage()
                .getH1();

        Assert.assertEquals(h2.getText(), "Twoje zamówienie zostało złożone!");
    }



    @Test
    public void buyProduct2() throws InterruptedException {
        WebElement h2 = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .goToHomePage()
                .chooseProduct()
                .addToCartPage()
                .goToCartPage()
                .chooseShip(1)
                .goToAddressDataPage()
                .chosePointOrlen()
                .goToSuccessPage()
                .getH1();

        Assert.assertEquals(h2.getText(), "Twoje zamówienie zostało złożone!");
    }




    @Test @Ignore
    public void buyProduct3() throws InterruptedException {
        WebElement h2 = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .goToHomePage()
                .chooseProduct()
                .addToCartPage()
                .goToCartPage()
                .chooseShip(2)
                .goToAddressDataPage()
                .searchPoint()
                .goToSuccessPage()
                .getH1();

        Assert.assertEquals(h2.getText(), "Twoje zamówienie zostało złożone!");
    }


    @Test
    public void buyProduct4() throws InterruptedException {
        WebElement h2 = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .goToHomePage()
                .chooseProduct()
                .addToCartPage()
                .goToCartPage()
                .chooseShip(3)
                .goToAddressDataPage()
                .goToSummaryPage("")
                .goToSuccessPage()
                .getH1();

        Assert.assertEquals(h2.getText(), "Twoje zamówienie zostało złożone!");
    }



    @Test
    public void buyProduct5() throws InterruptedException {
        WebElement h2 = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .goToHomePage()
                .chooseProduct()
                .addToCartPage()
                .goToCartPage()
                .chooseShip(4)
                .goToAddressDataPage()
                .goToSummaryPage("")
                .goToSuccessPage()
                .getH1();

        Assert.assertEquals(h2.getText(), "Twoje zamówienie zostało złożone!");
    }


    @Test
    public void buyProduct6() throws InterruptedException {
        WebElement h2 = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .goToHomePage()
                .chooseProduct()
                .addToCartPage()
                .goToCartPage()
                .choosePoint()
                .goToAddressDataPage()
                .goToSummaryPage("")
                .goToSuccessPage()
                .getH1();

        Assert.assertEquals(h2.getText(), "Twoje zamówienie zostało złożone!");
    }


    @Test
    public void buyProduct7() throws InterruptedException {
        WebElement h2 = new HomePage(driver)
                .goToLogInPage()
                .putData("damian.mucus+test1@arete33.pl", "testerzy123")
                .goToHomePage()
                .chooseProduct()
                .addToCartPage()
                .goToCartPage()
                .odbiory1()
                .goToAddressDataPage()
                .goToSummaryPage2("")
                .goToSuccessPage2()
                .getH1();

        Assert.assertEquals(h2.getText(), "Twoje zamówienie zostało złożone!");
    }








}
























