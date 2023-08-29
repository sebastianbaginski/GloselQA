package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

    private WebDriver driver;
    @FindBy(className = "btn-red-inner")
    private WebElement addToWishListBtn;
    @FindBy(className = "delete-from-wishlist")
    private WebElement deleteProductLink;
    @FindBy(className = "no-result")
    private WebElement result;


    public WishListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement deleteProductFromWishList(){
        addToWishListBtn.click();
        deleteProductLink.click();
        return result;
    }
}
