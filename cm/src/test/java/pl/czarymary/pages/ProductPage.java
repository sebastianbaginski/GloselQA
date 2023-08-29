package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(id = "ProductAddToWhishlist")
    private WebElement addToWishList;
    @FindBy(id = "ProductAddToCartButton")
    private WebElement goToAddToCartPage;


    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WishListPage addToWishList() {
        addToWishList.click();
        return new WishListPage(driver);
    }

    public AddToCartPage addToCartPage() {
        goToAddToCartPage.click();
        return new AddToCartPage(driver);
    }



}
