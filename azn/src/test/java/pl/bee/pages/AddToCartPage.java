package pl.bee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;


public class AddToCartPage {

    @FindBy(className = "shopping_cart")
    private WebElement goToCartButton;

    protected WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CartPage goToCart() throws InterruptedException {
        Thread.sleep(2000);
        goToCartButton.click();
        return new CartPage(driver);
    }
}
