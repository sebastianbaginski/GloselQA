package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.czarymary.utils.SeleniumHelper;

public class SearchedPage {

    private WebDriver driver;
    @FindBy(className = "ModuleCLine")
    private WebElement h2;
    @FindBy(className = "noProductFound")
    private WebElement noProductMsg;
    @FindBy(className = "AddToCartOnList")
    private WebElement addToCartBtn;

    public SearchedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getResult() {
        SeleniumHelper.waitForVisibility(h2, driver);
        return h2.getText();
    }

    public String getMsg() {
        SeleniumHelper.waitForVisibility(noProductMsg, driver);
        return noProductMsg.getText();
    }

    public AddToCartPage addProductToCart(){
        addToCartBtn.click();
        return new AddToCartPage(driver);
    }
}


