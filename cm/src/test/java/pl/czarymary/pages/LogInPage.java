package pl.czarymary.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.czarymary.models.RegisterCustomer;
import pl.czarymary.utils.SeleniumHelper;

public class LogInPage {

    private WebDriver driver;
    @FindBy(id = "loginEmail")
    private WebElement emailInput;
    @FindBy(id = "loginPassword")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Zaloguj się')]")
    private WebElement logInBtn;
    @FindBy(id = "registerFirstName")
    private WebElement registerFirstNameInput;
    @FindBy(id = "registerLastName")
    private WebElement registerLastNameInput;
    @FindBy(id = "inputPhone")
    private WebElement registerPhoneInput;
    @FindBy(id = "registerEmail")
    private WebElement registerEmailInput;
    @FindBy(id = "registerPassword")
    private WebElement registerPasswordInput;
    @FindBy(id = "registerPassword1")
    private WebElement registerPassword1Input;
    @FindBy(id = "registerAgree")
    private WebElement registerAgreeCheckout;
    @FindBy(id = "CreateAccountSubmit")
    private WebElement createAccountBtn;
    @FindBy(tagName = "em")
    private WebElement error;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedPage putData(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        logInBtn.click();
        return new LoggedPage(driver);

    }

    public String getError() {
        SeleniumHelper.waitForVisibility(error, driver);
        return error.getText();
    }

    private void putRegisterData(RegisterCustomer registerCustomer) {
        registerFirstNameInput.sendKeys(registerCustomer.getFirstName());
        registerLastNameInput.sendKeys(registerCustomer.getLastName());
        registerPhoneInput.sendKeys(registerCustomer.getPhone());
        registerEmailInput.sendKeys(registerCustomer.getEmail());
        registerPasswordInput.sendKeys(registerCustomer.getPassword());
        registerPassword1Input.sendKeys(registerCustomer.getConfirmPassword());
        registerAgreeCheckout.click();
        SeleniumHelper.executorClick(createAccountBtn, driver);

    }

    public LoggedPage registerUser(RegisterCustomer registerCustomer) {
        putRegisterData(registerCustomer);
        return new LoggedPage(driver);
    }

    public WebElement registerUserWithInvalidData(RegisterCustomer registerCustomer) {
        putRegisterData(registerCustomer);
        return error;
    }

}
