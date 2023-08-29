package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'przejdź do koszyka')]")
    private WebElement goToCartPageBtn;


    public AddToCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CartPage goToCartPage(){
        goToCartPageBtn.click();
        return new CartPage(driver);
    }


}