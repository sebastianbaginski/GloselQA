package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.taniaksiazka.utils.SeleniumHelper;

public class LoggedPage {

    protected WebDriver driver;

    @FindBy(xpath = "//h3[contains(text(),'Twoje konto')]")
    private WebElement h3;

    @FindBy(className = "user")
    private WebElement yourAccButton;

    @FindBy(partialLinkText = "adresowa")
    private WebElement addressBookButton;

    public LoggedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean isH3Displayed() {
        return h3.isDisplayed();
    }


    public AddressBookPage chooseAddressBook(WebDriver driver) {
        SeleniumHelper.waitForVisibility(yourAccButton, driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(yourAccButton).build().perform();
        addressBookButton.click();
        return new AddressBookPage(driver);
    }
}