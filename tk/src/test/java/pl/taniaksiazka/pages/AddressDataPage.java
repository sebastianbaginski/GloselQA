package pl.taniaksiazka.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.taniaksiazka.utils.SeleniumHelper;

public class AddressDataPage {

    protected WebDriver driver;
    private JavascriptExecutor jsExecutor;
    @FindBy(id = "checkout_next_step_btn")
    private WebElement nextButton;
    @FindBy(name = "SelectedAddress")
    private WebElement address;

    @FindBy(id = "submitForm")
    private WebElement goSubmit;

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
    @FindBy(css = "a.btn.btn-primary.btn-sm.display-block.select-point")
    private WebElement chosePointMap;
    @FindBy(id = "shipping-points-search-submit")
    private WebElement getSearchPoint;
    @FindBy(xpath = "//div[contains(@style, 'width: 47px; height: 60px;')]")
    private WebElement mapPointOrlen;




    public AddressDataPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor) driver;
        this.driver = driver;
    }

    public SummaryPage goToSummaryPage() {

        try {
            SeleniumHelper.executorClick(address, driver);
        } catch (Exception e) {
            System.out.println("element doesn't exist");
        }

        SeleniumHelper.scrollToDownPage(driver);
        SeleniumHelper.executorClick(nextButton, driver);

        return new SummaryPage(driver);

    }

    public SummaryPage chosePoint() throws InterruptedException {
        searchPoint.clear();
        Thread.sleep(300);
        searchPoint.sendKeys("Białystok");
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
        searchPoint.sendKeys("Białystok");
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





    public SummaryPage goToSummaryPageNoAccount() throws InterruptedException {
        setInputName.sendKeys("Damian");
        Thread.sleep(500);
        setLastName.sendKeys("Tester");
        Thread.sleep(500);
       /* setAddres.sendKeys("Sezamkowa 2/4");
        Thread.sleep(500);
        setZipCode.sendKeys(("15-054"));
        setCity.sendKeys("Białystok");*/
        setPhone.sendKeys("577-281-091");
        setEmail.sendKeys("damian.mucus+test7@arete33.pl");
        checkRegisterAgree.click();



        SeleniumHelper.scrollToDownPage(driver);
        SeleniumHelper.executorClick(nextButton, driver);

        return new SummaryPage(driver);

    }


    public SummaryPage goToSummaryPage2() {


        SeleniumHelper.scrollToDownPage(driver);
        SeleniumHelper.executorClick(goSubmit, driver);

        return new SummaryPage(driver);

    }

}