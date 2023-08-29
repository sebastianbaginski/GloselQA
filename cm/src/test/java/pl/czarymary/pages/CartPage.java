package pl.czarymary.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.czarymary.utils.SeleniumHelper;

import java.util.List;

public class CartPage {

    private WebDriver driver;
    @FindBy(id = "UchoTotalDL")
    private WebElement price;
    @FindBy(name = "manual")
    private WebElement goNextBtn;
    @FindBy(name = "Shipping")
    private List<WebElement> shipList;
    @FindBy(linkText = "KLIKNIJ TUTAJ")
    private WebElement doNotCombineButton;
    @FindBy(id = "OS-select")
    private WebElement select;

    @FindBy(xpath = "//select[@id='KRNAD-select']/option[@value='1' and @selected='']")
    private WebElement point;

    @FindBy(id = "KRNADCityID")
    private WebElement point1;

    @FindBy(xpath = "//option[@value='OS-BI1']")
    private WebElement odbiory;

    @FindBy(id = "OS-select")
    private WebElement clickPoint;

    @FindBy(id ="OS")
    private WebElement chosePointOS;

    @FindBy(id = "KR_NAD")
    private WebElement nadawanie;

    @FindBy(id = "KR_NAD-select")
    private WebElement listaNadawnaie;

    @FindBy(xpath = "//option[@value='1']")
    private WebElement nadawaniePoint1;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

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


    public CartPage odbiory1() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", chosePointOS);
        Thread.sleep(1000);
        chosePointOS.click();
        Thread.sleep(3000);
        odbiory.click();
        return new CartPage(driver);
    }


    public CartPage chooseShip(int i) throws InterruptedException {
        SeleniumHelper.executorClick(shipList.get(i), driver);
        if(i==5){
            SeleniumHelper.waitForVisibility(select, driver);
            Select s = new Select(select);
            s.selectByIndex(1);
        }
        Thread.sleep(3000);

        return new CartPage(driver);
    }

    public CartPage chooseShip2(int i) throws InterruptedException {
        SeleniumHelper.executorClick(shipList.get(i), driver);
        if(i==5){
            SeleniumHelper.waitForVisibility(select, driver);
            Select s = new Select(select);
            s.selectByIndex(1);
        }
        Thread.sleep(3000);

        return new CartPage(driver);
    }

    public CartPage doNotCombineOrders(int i) {
        if(i!=0){
            SeleniumHelper.waitForVisibility(doNotCombineButton, driver);
            SeleniumHelper.executorClick(doNotCombineButton, driver);
        }
        return new CartPage(driver);
    }



    public AddressDataPage goToAddressDataPage() {

        SeleniumHelper.scrollToViewElement(price, driver);
        SeleniumHelper.executorClick(goNextBtn, driver);
        return new AddressDataPage(driver);
    }


    public AddressDataPage goToAddressDataPage2() {

        SeleniumHelper.scrollToViewElement(price, driver);
        SeleniumHelper.executorClick(goNextBtn, driver);
        return new AddressDataPage(driver);
    }


}