package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.czarymary.utils.SeleniumHelper;

public class LoggedPage {

    private WebDriver driver;
    @FindBy(tagName = "h3")
    private WebElement h3;
    @FindBy(xpath = "//*[@alt='Profesjonalny Sklep Ezoteryczny CzaryMary.pl']")
    private WebElement goToHomePageBtn;

    public LoggedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public String getResult() {
        SeleniumHelper.waitForVisibility(h3, driver);
        return h3.getText();
    }

    public HomePage goToHomePage() {
        goToHomePageBtn.click();
        return new HomePage(driver);
    }

}
