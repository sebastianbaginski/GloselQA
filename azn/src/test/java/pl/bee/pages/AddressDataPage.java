package pl.bee.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

public class AddressDataPage {

    @FindBy(xpath = "//div[contains(text(),'Wszelkie prawa zastrzeżone 2023')]")
    private WebElement footer;

    @FindBy(id = "checkout_next_step_btn")
    private WebElement nextButton;

    @FindBy(id = "submitForm")
    private WebElement nextButton2;

    @FindBy(tagName = "h2")
    private WebElement h2;
    @FindBy(tagName = "h3")
    private WebElement h3;

    @FindBy(id = "inputName")
    private WebElement setInputName;

    @FindBy(id = "inputLastName")
    private WebElement setLastName;

    @FindBy(id = "inputNumber")
    private WebElement setAddres;

    @FindBy(id = "inputZipcode")
    private WebElement setZipCode;

    @FindBy(id = "inputCity")
    private WebElement setCity;

    @FindBy(id = "inputPhone")
    private WebElement setPhone;

    @FindBy(id = "registerEmail")
    private WebElement setEmail;

    @FindBy(id = "registerAgree")
    private WebElement checkRegisterAgree;


    @FindBy(id = "shipping-points-search")
    private WebElement searchPoint;
    @FindBy(xpath = "//div[contains(@style, 'width: 56px; height: 60px;')]")
    private WebElement mapPoint;
    @FindBy(xpath = "//div[contains(@style, 'width: 47px; height: 60px;')]")
    private WebElement mapPointOrlen;
    @FindBy(css = "a.btn.btn-primary.btn-sm.display-block.select-point")
    private WebElement chosePointMap;
    @FindBy(id = "shipping-points-search-submit")
    private WebElement getSearchPoint;


    protected WebDriver driver;
    private JavascriptExecutor jsExecutor;
    public AddressDataPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    public SummaryPage goToSummaryPage() {

        SeleniumHelper.waitForVisibility(h2, driver);
        SeleniumHelper.scrollToViewElement(footer, driver);

        SeleniumHelper.waitForVisibility(nextButton, driver);
        SeleniumHelper.executorClick(nextButton, driver);
        return new SummaryPage(driver);
    }


    public SummaryPage chosePointInpost() throws InterruptedException {
        searchPoint.clear();
        Thread.sleep(300);
        searchPoint.sendKeys("Poznań");
        Thread.sleep(300);
        getSearchPoint.click();
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].click();", mapPoint);
        Thread.sleep(2000);
        chosePointMap.click();
        Thread.sleep(2000);
        nextButton.click();

        return new SummaryPage(driver);

    }


    public SummaryPage chosePointOrlen() throws InterruptedException {
        searchPoint.clear();
        Thread.sleep(300);
        searchPoint.sendKeys("Poznań");
        Thread.sleep(300);
        getSearchPoint.click();
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].click();", mapPointOrlen);
        Thread.sleep(2000);
        chosePointMap.click();
        Thread.sleep(2000);
        nextButton.click();

        return new SummaryPage(driver);

    }







    public SummaryPage goToSummaryPage2() {

        SeleniumHelper.waitForVisibility(h3, driver);
        SeleniumHelper.scrollToViewElement(footer, driver);

        SeleniumHelper.waitForVisibility(nextButton2, driver);
        SeleniumHelper.executorClick(nextButton2, driver);
        return new SummaryPage(driver);
    }


    public SummaryPage goToSummaryPageNoAccount() throws InterruptedException {
        setInputName.sendKeys("Damian");
        Thread.sleep(500);
        setLastName.sendKeys("Tester");
        Thread.sleep(500);
        setAddres.sendKeys("Sezamkowa 2/4");
        Thread.sleep(500);
        setZipCode.sendKeys(("15-054"));
        setCity.sendKeys("Białystok");
        setPhone.sendKeys("577-281-091");
        setEmail.sendKeys("damian.mucus+test7@arete33.pl");
        checkRegisterAgree.click();

        SeleniumHelper.waitForVisibility(nextButton, driver);
        SeleniumHelper.executorClick(nextButton, driver);
        return new SummaryPage(driver);
    }



}
