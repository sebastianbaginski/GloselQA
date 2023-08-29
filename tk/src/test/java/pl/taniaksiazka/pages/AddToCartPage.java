package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.taniaksiazka.utils.SeleniumHelper;

public class AddToCartPage {

    protected WebDriver driver;
    @FindBy(linkText = "przejdź do koszyka")
    private WebElement nextButton;

    public AddToCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CartPage goToCart() {
        SeleniumHelper.executorClick(nextButton, driver);
        return new CartPage(driver);
    }

}
