package pl.bee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

public class LoggedPage {

    @FindBy(className = "page-heading")
    private WebElement h1;

    @FindBy(xpath = "//img[@alt='Bee.pl - sklep z ekologicznymi kosmetykami i zdrową żywnością']")
    private WebElement logoImg;

    protected WebDriver driver;

    public LoggedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public String getH1Text() {
        SeleniumHelper.waitForVisibility(h1, driver);
        return h1.getText();
    }

    public HomePage goToHomePage() {
        SeleniumHelper.waitForVisibility(h1, driver);
        logoImg.click();
        return new HomePage(driver);
    }
}
