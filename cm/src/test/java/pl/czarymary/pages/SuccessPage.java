package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.czarymary.utils.SeleniumHelper;

public class SuccessPage {

    private WebDriver driver;
    @FindBy(tagName = "h1")
    private WebElement h1;

    public SuccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getH1() {
        SeleniumHelper.waitForVisibility(h1, driver);
        return h1;
    }


}
