package pl.bee.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

import java.util.List;

public class ProductsPage {


    @FindBy(className = "atc-submit-btn")
    WebElement toCartButton;

    @FindBy(className = "wish-list-nopopup")
    WebElement toWishListButton;



    protected WebDriver driver;

    public ProductsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public AddToCartPage goToNextPage() throws InterruptedException {

        SeleniumHelper.waitForVisibility(toCartButton,driver);
        SeleniumHelper.executorClick(toCartButton,driver);
        return new AddToCartPage(driver);
    }



    public WishListPage addProductToWishList() {
        SeleniumHelper.scrollToViewElement(toWishListButton,driver);
        SeleniumHelper.waitForVisibility(toWishListButton,driver);
        SeleniumHelper.executorClick(toWishListButton,driver);
        return new WishListPage(driver);
    }


}
