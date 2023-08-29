package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.taniaksiazka.utils.SeleniumHelper;

public class SuccessPage {
    protected WebDriver driver;
    @FindBy(xpath = "//*[@id='success-content']//h1")
    private WebElement h1;



    public SuccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getResult() {
        SeleniumHelper.waitForVisibility(h1, driver);
        return h1.getText();
    }
}
