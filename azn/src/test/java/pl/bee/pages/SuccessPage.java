package pl.bee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

public class SuccessPage {


    @FindBy(xpath = "//h1[contains(text(),'Twoje zamówienie zostało złożone!')]")
    private WebElement result;

    @FindBy(xpath = "//div[@id='logotype-mbank-title' and @class='logo-title']")
    private WebElement mbank;


            protected WebDriver driver;

    public SuccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String checkResult() {
        SeleniumHelper.waitForVisibility(result, driver);
        return result.getText();
    }

    public String checkResultMbank() {
        SeleniumHelper.waitForVisibility(mbank, driver);
        return result.getText();
    }


}
