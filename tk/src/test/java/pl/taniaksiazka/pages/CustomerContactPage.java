package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.taniaksiazka.utils.SeleniumHelper;

public class CustomerContactPage {

    protected WebDriver driver;
    @FindBy(name = "ContactFormCustomerName")
    private WebElement nameInput;
    @FindBy(name = "ContactFormEmail")
    private WebElement emailInput;
    @FindBy(name = "ContactFormPhone")
    private WebElement phoneInput;
    @FindBy(name = "ContactFormMessage")
    private WebElement msgInput;
    @FindBy(name = "ContactFormSubmitButton")
    private WebElement sendBtn;
    @FindBy(xpath = "//div[contains(text(),'Dziękujemy za kontakt. Postaramy się jak najszybci')]")
    private WebElement resultText;

    public CustomerContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CustomerContactPage fillData(String name, String email, String phone, String msg) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        msgInput.sendKeys(msg);
        SeleniumHelper.executorClick(sendBtn, driver);
        return new CustomerContactPage(driver);
    }

    public boolean isResultTextExist() {
        SeleniumHelper.waitForVisibility(resultText, driver);
        return resultText.isEnabled();
    }
}
