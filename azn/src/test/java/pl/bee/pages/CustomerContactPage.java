package pl.bee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;

public class CustomerContactPage {

    @FindBy(name = "ContactFormCustomerName")
    private WebElement inputName;

    @FindBy(name = "ContactFormEmail")
    private WebElement inputEmail;

    @FindBy(name = "ContactFormPhone")
    private WebElement inputPhone;

    @FindBy(name = "ContactFormMessage")
    private WebElement inputMsg;

    @FindBy(name = "ContactFormSubmitButton")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[contains(text(),'Dziękujemy za kontakt. Postaramy się jak najszybci')]")
    private WebElement resultMsg;

    protected WebDriver driver;

    public CustomerContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public WebElement putData(String name, String email, String phone, String msg) {
        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        inputPhone.sendKeys(phone);
        inputMsg.sendKeys(msg);
        submitBtn.click();
        SeleniumHelper.waitForVisibility(resultMsg, driver);
        return resultMsg;
    }
}