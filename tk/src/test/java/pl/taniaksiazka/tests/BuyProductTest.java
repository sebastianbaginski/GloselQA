package pl.taniaksiazka.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pl.taniaksiazka.pages.CartPage;
import pl.taniaksiazka.pages.HomePage;

public class BuyProductTest extends BaseTest {


    @Test
    public void buyProductForEveryShipPointInpost() throws InterruptedException {

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123");

        for (int i = 0; i < 1; i++) {

            String buyResult = new HomePage(driver)
                    .hoverToCategory(driver)
                    .chooseBooksCategory(driver)
                    .chooseProduct()
                    .goToCart()
                    .doNotCombineOrders(i)
                    .chooseOrderAndGoAddressDataPage(i)
                    .chosePoint()
                    .acceptAll(homePageURL)
                    .getResult();

            Assert.assertEquals(buyResult, "Twoje zamówienie zostało złożone!");

        }
    }

    @Test
    public void buyProductForEveryShip2() throws InterruptedException {

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123");

        for (int i = 1; i < 2; i++) {

            String buyResult = new HomePage(driver)
                    .hoverToCategory(driver)
                    .chooseBooksCategory(driver)
                    .chooseProduct()
                    .goToCart()
                    .doNotCombineOrders2(i)
                    .chooseOrderAndGoAddressDataPage(i)
                    .chosePointOrlen()
                    .acceptAll(homePageURL)
                    .getResult();

            Assert.assertEquals(buyResult, "Twoje zamówienie zostało złożone!");

        }
    }


    @Test @Ignore
    public void buyProductForEveryShip3() throws InterruptedException {

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123");

        for (int i = 2; i < 3; i++) {

            String buyResult = new HomePage(driver)
                    .hoverToCategory(driver)
                    .chooseBooksCategory(driver)
                    .chooseProduct()
                    .goToCart()
                    .doNotCombineOrders3(i)
                    .chooseOrderAndGoAddressDataPage(i)
                    .chosePointOrlen()
                    .acceptAll(homePageURL)
                    .getResult();

            Assert.assertEquals(buyResult, "Twoje zamówienie zostało złożone!");

        }
    }



    @Test
    public void buyProductForEveryShip4() throws InterruptedException {

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123");

        for (int i = 3; i < 4; i++) {

            String buyResult = new HomePage(driver)
                    .hoverToCategory(driver)
                    .chooseBooksCategory(driver)
                    .chooseProduct()
                    .goToCart()
                    .doNotCombineOrders4(i)
                    .chooseOrderAndGoAddressDataPage(i)
                    .goToSummaryPage()
                    .acceptAll(homePageURL)
                    .getResult();

            Assert.assertEquals(buyResult, "Twoje zamówienie zostało złożone!");

        }
    }

    @Test
    public void buyProductForEveryShip5() throws InterruptedException {

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123");

        for (int i = 4; i < 5; i++) {

            String buyResult = new HomePage(driver)
                    .hoverToCategory(driver)
                    .chooseBooksCategory(driver)
                    .chooseProduct()
                    .goToCart()
                    .doNotCombineOrders5(i)
                    .chooseOrderAndGoAddressDataPage(i)
                    .goToSummaryPage()
                    .acceptAll(homePageURL)
                    .getResult();

            Assert.assertEquals(buyResult, "Twoje zamówienie zostało złożone!");

        }
    }

    @Test
    public void buyProductForEveryShip6() throws InterruptedException {

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123");

        for (int i = 5; i < 6; i++) {

            String buyResult = new HomePage(driver)
                    .hoverToCategory(driver)
                    .chooseBooksCategory(driver)
                    .chooseProduct()
                    .goToCart()
                    .doNotCombineOrders6(i)
                    .chooseOrderAndGoAddressDataPage2(i)
                    .goToSummaryPage()
                    .acceptAll(homePageURL)
                    .getResult();

            Assert.assertEquals(buyResult, "Twoje zamówienie zostało złożone!");

        }
    }

    @Test
    public void buyProductForEveryShip7() throws InterruptedException {

        new HomePage(driver)
                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123");

        for (int i = 6; i < 7; i++) {

            String buyResult = new HomePage(driver)
                    .hoverToCategory(driver)
                    .chooseBooksCategory(driver)
                    .chooseProduct()
                    .goToCart()
                    .chooseOrderAndGoAddressDataPage3(i)
                    .goToSummaryPage2()
                    .acceptAll(homePageURL)
                    .getResult();

            Assert.assertEquals(buyResult, "Twoje zamówienie zostało złożone!");

        }
    }


    // Bez Zakladania Konta //

    @Test
    public void buyProductForEveryShipNoAccount1() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.closeCookieBar();

        for (int i = 3; i < 4; i++) {

            String buyResult = new HomePage(driver)
                    .hoverToCategory(driver)
                    .chooseBooksCategory(driver)
                    .chooseProduct()
                    .goToCart()
                    .doNotCombineOrders4(i)
                    .chooseOrderAndGoAddressDataPagePaymentAdvance(i)
                    .goToSummaryPageNoAccount()
                    .acceptAll(homePageURL)
                    .getResult();

            Assert.assertEquals(buyResult, "Twoje zamówienie zostało złożone!");

        }
    }



}
