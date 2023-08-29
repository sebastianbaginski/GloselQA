package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.taniaksiazka.models.RegisterCustomer;
import pl.taniaksiazka.utils.SeleniumHelper;

public class LogInPage {

    protected WebDriver driver;
    @FindBy(id = "loginEmail")
    private WebElement logInInput;
    @FindBy(id = "loginPassword")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(text(),'Zaloguj się')]")
    private WebElement logInButton;
    @FindBy(tagName = "em")
    private WebElement error;
    @FindBy(id = "registerFirstName")
    private WebElement registerFirstNameInput;
    @FindBy(id = "registerLastName")
    private WebElement registerLastNameInput;
    @FindBy(id = "registerPhone")
    private WebElement registerPhoneInput;
    @FindBy(id = "registerEmail")
    private WebElement registerEmailInput;
    @FindBy(id = "registerPassword")
    private WebElement registerPasswordInput;
    @FindBy(id = "registerPassword1")
    private WebElement registerPassword1;
    @FindBy(id = "registerAgree")
    private WebElement registerAgree;
    @FindBy(id = "CreateAccountSubmit")
    private WebElement createAccountButton;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void setUserEmailAndPass(String email, String password) {
        logInInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public LoggedPage logIn(String email, String password) {
        setUserEmailAndPass(email, password);
        logInButton.click();
        return new LoggedPage(driver);
    }

    public String logInWithoutPassword(String email, String password) {
        setUserEmailAndPass(email, password);
        logInButton.click();
        SeleniumHelper.waitForVisibility(error, driver);
        return error.getText();
    }

    public HomePage registerUser(RegisterCustomer registerCustomer, String accept) {
        fillRegisterData(registerCustomer);

        if (!accept.equals("Don't accept")) registerAgree.click();
        SeleniumHelper.executorClick(createAccountButton, driver);
        return new HomePage(driver);
    }

    private void fillRegisterData(RegisterCustomer registerCustomer) {
        registerFirstNameInput.sendKeys(registerCustomer.getFirstName());
        registerLastNameInput.sendKeys(registerCustomer.getLastName());
        registerPhoneInput.sendKeys(registerCustomer.getPhone());
        registerEmailInput.sendKeys(registerCustomer.getEmail());
        registerPasswordInput.sendKeys(registerCustomer.getPassword());
        registerPassword1.sendKeys(registerCustomer.getConfirmPassword());
    }

    public String registerError() {
        return error.getText();
    }
}