package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    protected WebDriver driver;
    @FindBy(tagName = "h1")
    private WebElement result;
    @FindBy(className = "no-result")
    private WebElement noResult;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getResult() {
        return result;
    }

    public WebElement getNoResult() {
        return noResult;
    }
}
