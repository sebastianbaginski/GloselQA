package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.czarymary.utils.SeleniumHelper;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    @FindBy(id = "SearchBarInput")
    private WebElement searchInput;
    @FindBy(id = "SearchBarButton")
    private WebElement searchButton;
    @FindBy(xpath = "//a[contains(text(),'Moje konto')]")
    private WebElement myAccBtn;
    @FindBy(tagName = "h3")
    private List<WebElement> products;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SearchedPage searchPhrase(String phrase) {
        searchInput.sendKeys(phrase);
        searchButton.click();
        return new SearchedPage(driver);
    }

    public LogInPage goToLogInPage() {
        myAccBtn.click();
        return new LogInPage(driver);
    }

    public ProductPage chooseProduct() {
        products.get(1).click();
        return new ProductPage(driver);
    }


}
