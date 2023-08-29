package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.czarymary.tests.BaseTest;
import pl.czarymary.utils.SeleniumHelper;

public class SummaryPage extends BaseTest {

    private WebDriver driver;
    @FindBy(id = "accept1")
    private WebElement accept1;
    @FindBy(id = "accept5")
    private WebElement accept2;
    @FindBy(tagName = "footer")
    private WebElement footer;
    @FindBy(id = "submitForm")
    private WebElement goNextBtn;

    @FindBy(tagName = "h2")
    private WebElement h2;

    public SummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SuccessPage goToSuccessPage() {
        SeleniumHelper.scrollToViewElement(footer, driver);
        SeleniumHelper.waitForVisibility(accept1, driver);
        SeleniumHelper.executorClick(accept1, driver);
        SeleniumHelper.executorClick(accept2, driver);
        SeleniumHelper.executorClick(goNextBtn, driver);
      /*  SeleniumHelper.waitForUrlNotContains("czarymary", driver);

        driver.get(homePageUrl + "Success");*/

        return new SuccessPage(driver);
    }

    public SuccessPage goToSuccessPagePoint() {
        SeleniumHelper.executorClick(goNextBtn,driver);
        SeleniumHelper.waitForVisibility(accept1, driver);
        SeleniumHelper.executorClick(accept1, driver);
        SeleniumHelper.executorClick(goNextBtn, driver);
      /*  SeleniumHelper.waitForUrlNotContains("czarymary", driver);

        driver.get(homePageUrl + "Success");*/

        return new SuccessPage(driver);
    }



    public SuccessPage goToSuccessPage2() {
        SeleniumHelper.scrollToViewElement(footer, driver);
        SeleniumHelper.waitForVisibility(accept1, driver);
        SeleniumHelper.executorClick(accept1, driver);
        SeleniumHelper.executorClick(goNextBtn, driver);
      /*  SeleniumHelper.waitForUrlNotContains("czarymary", driver);

        driver.get(homePageUrl + "Success");*/

        return new SuccessPage(driver);
    }


}
