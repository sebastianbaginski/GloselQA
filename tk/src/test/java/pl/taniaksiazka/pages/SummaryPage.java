package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.taniaksiazka.utils.SeleniumHelper;

public class SummaryPage {

    protected WebDriver driver;
    @FindBy(id = "submitForm")
    private WebElement submitButton;
    @FindBy(id = "acceptAll")
    private WebElement acceptAll;
    @FindBy(id = "acceptOpinie")
    private WebElement acceptOpinions;
    @FindBy(id = "submitForm")
    private WebElement nextButton;

    public SummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SuccessPage acceptAll(String homePageURL) {

        SeleniumHelper.scrollToDownPage(driver);

        SeleniumHelper.executorClick(acceptAll, driver);
        SeleniumHelper.executorClick(acceptOpinions, driver);
        SeleniumHelper.executorClick(submitButton, driver);
        /*SeleniumHelper.waitForUrlNotContains(homePageURL, driver);

        driver.get(homePageURL + "Success");*/
        return new SuccessPage(driver);
    }

    public SuccessPage acceptAll1(String homePageURL) {

        nextButton.click();
        SeleniumHelper.executorClick(acceptAll, driver);
        SeleniumHelper.executorClick(submitButton, driver);
        return new SuccessPage(driver);
    }

}
