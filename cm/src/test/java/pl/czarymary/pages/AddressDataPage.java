package pl.czarymary.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.czarymary.utils.SeleniumHelper;

public class AddressDataPage {

    private WebDriver driver;
    private JavascriptExecutor jsExecutor;


    @FindBy(tagName = "footer")
    private WebElement footer;
    @FindBy(id = "checkout_next_step_btn")
    private WebElement goNextBtn;
    @FindBy(xpath = "//*[@id='InfoWasAdded']/a")
    private WebElement productLink;
    @FindBy(id = "accept1")
    private WebElement regulaminZabijania;
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

    public SummaryPage goToSummaryPage(String msg) {
        if (!msg.equals("skip")) {
            SeleniumHelper.scrollToViewElement(footer, driver);
            SeleniumHelper.executorClick(goNextBtn, driver);
        }
        return new SummaryPage(driver);
    }

    public SummaryPage searchPoint() throws InterruptedException {
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
       goNextBtn.click();


        return new SummaryPage(driver);
    }

    public SummaryPage chosePointOrlen() throws InterruptedException {
        searchPoint.clear();
        Thread.sleep(600);
        searchPoint.sendKeys("Poznań");
        Thread.sleep(600);
        getSearchPoint.click();
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].click();", mapPointOrlen);
        Thread.sleep(2000);
        chosePointMap.click();
        Thread.sleep(2000);
        goNextBtn.click();

        return new SummaryPage(driver);

    }




    public SummaryPage goToSummaryPage2(String msg) {
        if (!msg.equals("skip")) {
            SeleniumHelper.scrollToViewElement(footer, driver);
/*
            SeleniumHelper.executorClick(goNextBtn, driver);
*/
        }
        return new SummaryPage(driver);
    }

}
