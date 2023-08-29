package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

    protected WebDriver driver;
    @FindBy(tagName = "h2")
    private WebElement h2;
    @FindBy(className = "next")
    private WebElement nextBtn;
    @FindBy(xpath = "//label[contains(text(),'zaznacz')]")
    private WebElement deleteLink;
    @FindBy(xpath = "//button[contains(text(),'usuń ze schowka')]")
    private WebElement deleteButton;
    @FindBy(xpath = "//h2[contains(text(),'Schowek jest pusty!')]")
    private WebElement result;
    @FindBy (className = "dialog-close-btn")
    private WebElement newsletter;

    public WishListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getH2() {
        return h2;
    }

    public WebElement deleteFromWishList() {
/*
        newsletter.click();
*/
        nextBtn.click();
        deleteLink.click();
        deleteButton.click();
        return result;
    }

}
