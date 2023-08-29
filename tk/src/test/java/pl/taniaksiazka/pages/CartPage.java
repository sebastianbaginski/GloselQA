package pl.taniaksiazka.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.taniaksiazka.utils.SeleniumHelper;

import java.util.List;

public class CartPage {

    protected WebDriver driver;
    @FindBy(partialLinkText = "usuń")
    private List<WebElement> itemsToRemove;
    @FindBy(xpath = "//div[contains(text(),'Twój koszyk istnieje')]")
    private WebElement resultMsg;
    @FindBy(name = "Shipping")
    private List<WebElement> shipMethods;
    @FindBy(name = "manual")
    private WebElement manualNext;
    @FindBy(id = "UchoTotalDL")
    private WebElement price;
    @FindBy(linkText = "KLIKNIJ TUTAJ")
    private WebElement doNotCombineButton;
    @FindBy(id = "OS-select")
    private WebElement personPickupsSelect;
    @FindBy(id = "UchoShipping")
    private WebElement shipList;
    @FindBy(id = "KR_NAD-select")
    private WebElement listaNadawnaie;
    @FindBy(xpath = "//option[@value='1']")
    private WebElement nadawaniePoint1;

    @FindBy(xpath = "//option[@value='OS-BI1']")
    private WebElement chosePointBialystok;

    @FindBy(xpath = "//input[@id='OS']")
    private WebElement chosePoint;

    @FindBy(id = "ADVANCE")
    private WebElement adancePayment;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int removeItems() {
        for (WebElement e : itemsToRemove) {
            SeleniumHelper.executorClick(e, driver);
        }
        SeleniumHelper.waitForVisibility(resultMsg, driver);
        return itemsToRemove.size();
    }


    public SummaryPage goToSummaryPage() {
        SeleniumHelper.scrollToViewElement(price, driver);
        manualNext.click();
        return new SummaryPage(driver);
    }

    public AddressDataPage chooseOrderAndGoAddressDataPage(int i) throws InterruptedException {
        SeleniumHelper.waitForVisibilityofList(shipMethods, driver);
        SeleniumHelper.executorClick(shipMethods.get(i), driver);



        SeleniumHelper.scrollToViewElement(price, driver);
        manualNext.click();
        return new AddressDataPage(driver);
    }


    public AddressDataPage chooseOrderAndGoAddressDataPagePaymentAdvance(int i) throws InterruptedException {
        SeleniumHelper.waitForVisibilityofList(shipMethods, driver);
        SeleniumHelper.executorClick(shipMethods.get(i), driver);
        adancePayment.click();



        SeleniumHelper.scrollToViewElement(price, driver);
        manualNext.click();
        return new AddressDataPage(driver);
    }


    public AddressDataPage chooseOrderAndGoAddressDataPage2(int i) throws InterruptedException {
        SeleniumHelper.waitForVisibilityofList(shipMethods, driver);
        SeleniumHelper.executorClick(shipMethods.get(i), driver);
        Thread.sleep(3000);
        listaNadawnaie.click();
        Thread.sleep(3000);
        nadawaniePoint1.click();



        SeleniumHelper.scrollToViewElement(price, driver);
        manualNext.click();
        return new AddressDataPage(driver);
    }


    public AddressDataPage chooseOrderAndGoAddressDataPage3(int i) throws InterruptedException {
        SeleniumHelper.waitForVisibilityofList(shipMethods, driver);
        SeleniumHelper.executorClick(shipMethods.get(i), driver);
        Thread.sleep(3000);
        chosePointBialystok.click();



        SeleniumHelper.scrollToViewElement(price, driver);
        manualNext.click();
        return new AddressDataPage(driver);
    }



    public CartPage doNotCombineOrders(int i) {
        if (i != 0) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }

    public CartPage doNotCombineOrders3(int i) {
        if (i != 2) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }




    public CartPage doNotCombineOrders2(int i) {
        if (i != 1) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }


    public CartPage doNotCombineOrders4(int i) {
        if (i != 3) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }

    public CartPage doNotCombineOrders5(int i) {
        if (i != 4) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }

    public CartPage doNotCombineOrders6(int i)  {
        if (i != 5) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }


    public CartPage doNotCombineOrders7(int i)  {
        if (i != 6) {

            chosePoint.click();
            chosePointBialystok.click();
        }
        return new CartPage(driver);
    }


    public SummaryPage choosePersonPickup(int i) {
        SeleniumHelper.executorClick(shipMethods.get(5), driver);
        Select personPickup = new Select(personPickupsSelect);
        personPickup.selectByIndex(i);
        SeleniumHelper.scrollToViewElement(price, driver);
        manualNext.click();
        return new SummaryPage(driver);
    }

    public int getPersonPickupSize() {
        Select ships = new Select(personPickupsSelect);
        return ships.getOptions().size();
    }
}