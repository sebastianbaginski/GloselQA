package pl.bee.tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pl.bee.models.MyAccounts;
import pl.bee.pages.CartPage;
import pl.bee.pages.HomePage;
import pl.bee.pages.SummaryPage;

public class BuyProductTest extends BaseTest {

    @Test
    public void buyProductForEveryShipMethodPointInpost () throws InterruptedException {
        test = extentReports.createTest("Buy Product for every shipping method");

        MyAccounts myAccounts = new MyAccounts();

        new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .logInWithCorrectlyData(myAccounts)
                .goToHomePage();

        for (int i = 0; i < 1; i++) { // w i bylo 5, zmienione na 3 do testow //
            String shipName = new HomePage(driver)
                    .chooseItem()
                    .goToNextPage()
                    .goToCart()
                    .doNotCombineOrders(i)
                    .getShipMethodName(i);

            String result = new CartPage(driver)
                    .goNext()
                    .chosePointInpost()
                    .goSuccessPage(homePageURL)
                    .checkResult();


            if (result.equals("Twoje zamówienie zostało złożone!")) {
                test.log(Status.PASS, "Bought for " + shipName + " correctly");
            } else test.log(Status.FAIL, "Test failed");

            Assert.assertEquals(result, "Twoje zamówienie zostało złożone!");

        }
        test.log(Status.PASS, "Buy product Test Passed");

    }


    @Test
    public void buyProductForEveryShipMethod () throws InterruptedException {
        test = extentReports.createTest("Buy Product for every shipping method");

        MyAccounts myAccounts = new MyAccounts();

        new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .logInWithCorrectlyData(myAccounts)
                .goToHomePage();

        for (int i = 1; i < 2; i++) { // w i bylo 5, zmienione na 3 do testow //
            String shipName = new HomePage(driver)
                    .chooseItem()
                    .goToNextPage()
                    .goToCart()
                    .doNotCombineOrders5(i)
                    .getShipMethodName(i);

            String result = new CartPage(driver)
                    .goNext()
                    .goToSummaryPage()
                    .goSuccessPage(homePageURL)
                    .checkResult();


            if (result.equals("Twoje zamówienie zostało złożone!")) {
                test.log(Status.PASS, "Bought for " + shipName + " correctly");
            } else test.log(Status.FAIL, "Test failed");

            Assert.assertEquals(result, "Twoje zamówienie zostało złożone!");

        }
        test.log(Status.PASS, "Buy product Test Passed");

    }




    @Test
    public void buyProductForEveryShipMethod2 () throws InterruptedException {
        test = extentReports.createTest("Buy Product for every shipping method");

        MyAccounts myAccounts = new MyAccounts();

        new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .logInWithCorrectlyData(myAccounts)
                .goToHomePage();

        for (int i = 2; i < 3; i++) { // w i bylo 5, zmienione na 3 do testow //
            String shipName = new HomePage(driver)
                    .chooseItem2()
                    .goToNextPage()
                    .goToCart()
                    .doNotCombineOrders2(i)
                    .getShipMethodName(i);

            String result = new CartPage(driver)
                    .goNext()
                    .goToSummaryPage()
                    .goSuccessPage(homePageURL)
                    .checkResult();


            if (result.equals("Twoje zamówienie zostało złożone!")) {
                test.log(Status.PASS, "Bought for " + shipName + " correctly");
            } else test.log(Status.FAIL, "Test failed");

            Assert.assertEquals(result, "Twoje zamówienie zostało złożone!");

        }
        test.log(Status.PASS, "Buy product Test Passed");

    }

    @Test
    public void buyProductForEveryShipMethod3 () throws InterruptedException {
        test = extentReports.createTest("Buy Product for every shipping method");

        MyAccounts myAccounts = new MyAccounts();

        new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .logInWithCorrectlyData(myAccounts)
                .goToHomePage();

        for (int i = 4; i < 5; i++) { // w i bylo 5, zmienione na 3 do testow //
            String shipName = new HomePage(driver)
                    .chooseItem3()
                    .goToNextPage()
                    .goToCart()
                    .doNotCombineOrders3(i)
                    .getShipMethodName(i);

            String result = new CartPage(driver)
                    .goNext()
                    .goToSummaryPage()
                    .goSuccessPage(homePageURL)
                    .checkResult();


            if (result.equals("Twoje zamówienie zostało złożone!")) {
                test.log(Status.PASS, "Bought for " + shipName + " correctly");
            } else test.log(Status.FAIL, "Test failed");

            Assert.assertEquals(result, "Twoje zamówienie zostało złożone!");

        }
        test.log(Status.PASS, "Buy product Test Passed");

    }

    @Test
    public void buyProductForEveryShipMethod4 () throws InterruptedException {
        test = extentReports.createTest("Buy Product for every shipping method");

        MyAccounts myAccounts = new MyAccounts();

        new HomePage(driver)
                .closeCookieBar()
                .goToLogInPage()
                .logInWithCorrectlyData(myAccounts)
                .goToHomePage();

        for (int i = 5; i < 6; i++) { // w i bylo 5, zmienione na 3 do testow //
            String shipName = new HomePage(driver)
                    .chooseItem3()
                    .goToNextPage()
                    .goToCart()
                    .choosePoint()
                    .getShipMethodName(i);

            String result = new CartPage(driver)
                    .goNext()
                    .goToSummaryPage()
                    .goSuccessPage(homePageURL)
                    .checkResult();


            if (result.equals("Twoje zamówienie zostało złożone!")) {
                test.log(Status.PASS, "Bought for " + shipName + " correctly");
            } else test.log(Status.FAIL, "Test failed");

            Assert.assertEquals(result, "Twoje zamówienie zostało złożone!");

        }
        test.log(Status.PASS, "Buy product Test Passed");

    }

        @Test
        public void buyProductForEveryShipMethod5 () throws InterruptedException {
            test = extentReports.createTest("Buy Product for every shipping method");

            MyAccounts myAccounts = new MyAccounts();

            new HomePage(driver)
                    .closeCookieBar()
                    .goToLogInPage()
                    .logInWithCorrectlyData(myAccounts)
                    .goToHomePage();

            for (int i = 6; i < 7; i++) { // w i bylo 5, zmienione na 3 do testow //
                String shipName = new HomePage(driver)
                        .chooseItem3()
                        .goToNextPage()
                        .goToCart()
                        .choosePoint()
                        .getShipMethodName(i);

                String result = new CartPage(driver)
                        .goNext()
                        .goToSummaryPage()
                        .goSuccessPage(homePageURL)
                        .checkResult();


                if (result.equals("Twoje zamówienie zostało złożone!")) {
                    test.log(Status.PASS, "Bought for " + shipName + " correctly");
                } else test.log(Status.FAIL, "Test failed");

                Assert.assertEquals(result, "Twoje zamówienie zostało złożone!");

            }
            test.log(Status.PASS, "Buy product Test Passed");

        }

            //BEZ ZAKŁADANIA KONTA//


    @Test
    public void buyProductForEveryShipMethod2NoAccount () throws InterruptedException {
        test = extentReports.createTest("Buy Product for every shipping method");

        HomePage homePage = new HomePage(driver);

                homePage.closeCookieBar();

        for (int i = 4; i < 5; i++) { // w i bylo 5, zmienione na 3 do testow //
            String shipName = new HomePage(driver)
                    .chooseItem2()
                    .goToNextPage()
                    .goToCart()
                    .doNotCombineOrders3(i)
                    .UchoPayment()
                    .getShipMethodName(i);



            String result = new CartPage(driver)
                    .goNext()
                    .goToSummaryPageNoAccount()
                    .goSuccessPage(homePageURL)
                    .checkResult();


            if (result.equals("Twoje zamówienie zostało złożone!")) {
                test.log(Status.PASS, "Bought for " + shipName + " correctly");
            } else test.log(Status.FAIL, "Test failed");

            Assert.assertEquals(result, "Twoje zamówienie zostało złożone!");

        }
        test.log(Status.PASS, "Buy product Test Passed");

    }

    }








