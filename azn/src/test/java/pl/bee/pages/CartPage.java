package pl.bee.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

import java.util.List;

public class CartPage {


    @FindBy(xpath = "//*[@id='UchoShipping']/div")
    private List<WebElement> shipListName;

    @FindBy(name = "Shipping")
    private List<WebElement> shipList;

    @FindBy(id = "ADVANCE")
    private WebElement transferPay;

    @FindBy(id = "UchoTotalDL")
    private WebElement price;

    @FindBy(name = "manual")
    private WebElement goNextBtn;

    @FindBy(linkText = "KLIKNIJ TUTAJ")
    private WebElement doNotCombineButton;

    @FindBy(id = "inputComment")
    private WebElement inputComment;

    @FindBy(id = "KR_NAD-select")
    private WebElement listaNadawnaie;

    @FindBy(xpath = "//option[@value='1']")
    private WebElement nadawaniePoint1;

    @FindBy(id = "KR_NAD")
    private WebElement nadawanie;

    @FindBy(id = "OS")
    private WebElement chosePointOS;

    @FindBy(xpath = "//option[@value='OS-BI1']")
    private WebElement odbiory;

    @FindBy(id = "ADVANCE")
    private WebElement TransferPay;

    @FindBy(id = "POBRANIE")
    private WebElement cashOnDelivery;


    protected WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public CartPage doNotCombineOrders(int i) {
        if (i != 0) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }
    public CartPage doNotCombineOrders5(int i) {
        if (i != 1) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }


    public CartPage doNotCombineOrders2(int i) {
        if (i != 2) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }

    public CartPage UchoPayment() {
        transferPay.click();
        return new CartPage(driver);
    }


    public CartPage doNotCombineOrders3(int i) {
        if (i != 4) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }

    public CartPage doNotCombineOrders4(int i) {
        if (i != 6) {
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }

    public CartPage choosePoint() throws InterruptedException {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", nadawanie);
        Thread.sleep(1000);
        nadawanie.click();
        Thread.sleep(3000);
        listaNadawnaie.click();
        Thread.sleep(3000);
        nadawaniePoint1.click();
        return new CartPage(driver);
    }

    public CartPage cashDelieveryy() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", cashOnDelivery);
        Thread.sleep(500);
        cashOnDelivery.click();
        return new CartPage(driver);
    }




    public CartPage odbiory1() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", chosePointOS);
        Thread.sleep(1000);
        chosePointOS.click();
        Thread.sleep(3000);
        odbiory.click();
        return new CartPage(driver);
    }

    public String getShipMethodName(int i) throws InterruptedException {

        /*SeleniumHelper.waitToVisibilityList(shipListName, driver);
        SeleniumHelper.waitToVisibilityList(shipList, driver);
        SeleniumHelper.scrollToViewElement(shipListName.get(i), driver);
        SeleniumHelper.executorClick(shipList.get(i), driver);*/
        SeleniumHelper.waitToVisibilityList(shipList, driver);
        SeleniumHelper.executorClick(shipList.get(i), driver);
        Thread.sleep(3000);

        SeleniumHelper.scrollToViewElement(price, driver);

        return shipListName.get(i).getText();
    }




    public AddressDataPage goNext() {
     //   SeleniumHelper.scrollToViewElement(inputComment, driver);
        SeleniumHelper.executorClick(goNextBtn, driver);
        return new AddressDataPage(driver);
    }

}






