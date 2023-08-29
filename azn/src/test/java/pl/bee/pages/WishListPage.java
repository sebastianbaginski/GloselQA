package pl.bee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

import java.util.List;


public class WishListPage {

    @FindBy(xpath = "//div[contains(text(),'dodano do schowka.')]")
    private WebElement addedToWishListResult;

    @FindBy(className = "icon-remove-sign")
    private List<WebElement> removeButton;

    @FindBy(xpath = "//div[contains(text(),'Schowek jest pusty.')]")
    private WebElement removedFromWishListResult;

    protected WebDriver driver;

    public WishListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getResult() {
        SeleniumHelper.waitForVisibility(addedToWishListResult, driver);
        return addedToWishListResult;
    }

    public boolean removeItems() {
        for (WebElement e : removeButton) {
            SeleniumHelper.executorClick(e, driver);
        }
        SeleniumHelper.waitForVisibility(removedFromWishListResult, driver);
        return removedFromWishListResult.isDisplayed();
    }

}
