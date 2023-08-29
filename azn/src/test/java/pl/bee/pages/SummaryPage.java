package pl.bee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

public class SummaryPage {

    @FindBy(id = "submitForm")
    private WebElement goNextBtn;

    @FindBy(id = "accept1")
    private WebElement accept1;

    @FindBy(id = "accept5")
    private WebElement accept5;


    @FindBy(id = "checkout_next_step_btn")
    private WebElement getGoNextBtn;

    @FindBy(className = "bank-0")
    private WebElement clickBank1;

    private final WebDriver driver;

    public SummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }



    public SuccessPage goSuccessPage(String homePageURL) {
        SeleniumHelper.scrollToDownPage(driver);
        SeleniumHelper.executorClick(accept1, driver);
        SeleniumHelper.executorClick(accept5, driver);

        SeleniumHelper.executorClick(goNextBtn, driver);

        /*SeleniumHelper.waitForUrlNotContains(homePageURL, driver);
        driver.get(homePageURL+ "Success");*/
        return new SuccessPage(driver);
    }

    public SuccessPage goSuccessPage2(String homePageURL) {
        SeleniumHelper.scrollToDownPage(driver);
        accept1.click();

        SeleniumHelper.executorClick(goNextBtn, driver);

        SeleniumHelper.waitForUrlNotContains(homePageURL, driver);
        driver.get(homePageURL+ "Success");
        return new SuccessPage(driver);
    }

    public SuccessPage goSuccessPageBank(String homePageURL) {
        SeleniumHelper.scrollToDownPage(driver);
        clickBank1.click();
        SeleniumHelper.executorClick(accept1, driver);
        SeleniumHelper.executorClick(accept5, driver);
        accept5.submit();
        return new SuccessPage(driver);
    }


}
