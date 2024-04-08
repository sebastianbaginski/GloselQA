package pl.bee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

public class SearchedPage {

    @FindBy(xpath = "//span[contains(text(),'Jest')]")
    private WebElement result;




    protected WebDriver driver;

    public SearchedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getElement() {
        SeleniumHelper.waitForVisibility(result, driver);
        return result;
    }

    public String getElemntStringa(){
        return result.getText();
    }


    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
