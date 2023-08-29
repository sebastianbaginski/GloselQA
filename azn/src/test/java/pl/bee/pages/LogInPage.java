package pl.bee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.models.AccountToRegister;
import pl.bee.models.MyAccounts;
import pl.bee.utils.SeleniumHelper;


public class LogInPage {

    @FindBy(id = "loginEmail")
    private WebElement loginInput;

    @FindBy(id = "loginPassword")
    private WebElement passInput;

    @FindBy(id = "SubmitLogin")
    private WebElement logInBtn;

    @FindBy(id = "registerFirstName")
    private WebElement registerFirstName;

    @FindBy(id = "registerLastName")
    private WebElement registerLastName;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "registerEmail")
    private WebElement registerEmail;

    @FindBy(id = "registerPassword")
    private WebElement registerPassword;

    @FindBy(id = "registerPassword1")
    private WebElement registerPassword1;

    @FindBy(id = "registerAgree")
    private WebElement registerAgree;

    @FindBy(className = "error")
    private WebElement error;

    @FindBy(id = "SubmitCreate")
    private WebElement registerBtn;

    protected WebDriver driver;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedPage logInWithCorrectlyData(MyAccounts mc) {
        putData(mc);
        SeleniumHelper.executorClick(logInBtn, driver);
        return new LoggedPage(driver);
    }

    public LogInPage logInWithoutEmail(MyAccounts mc) {
        putData(mc);
        SeleniumHelper.executorClick(logInBtn, driver);
        return new LogInPage(driver);
    }

    private void putData(MyAccounts mc) {
        loginInput.sendKeys(mc.getLogIn());
        passInput.sendKeys(mc.getPassword());
    }


    private void getRegister(AccountToRegister accountToRegister) {
        registerFirstName.sendKeys(accountToRegister.getFirstName());
        registerLastName.sendKeys(accountToRegister.getLastName());
        phoneInput.sendKeys(accountToRegister.getPhone());
        registerEmail.sendKeys(accountToRegister.getEmail());
        registerPassword.sendKeys(accountToRegister.getPass());
        registerPassword1.sendKeys(accountToRegister.getConfPass());
        if (!accountToRegister.getFirstName().equals("Adam")) {
            SeleniumHelper.executorClick(registerAgree, driver);
        }
        SeleniumHelper.executorClick(registerBtn, driver);
    }

    public HomePage registerUser(AccountToRegister accountToRegister) {
        getRegister(accountToRegister);
        return new HomePage(driver);
    }


    public LogInPage registerUserWithExistingEmail(AccountToRegister accountToRegister) {
        getRegister(accountToRegister);
        return new LogInPage(driver);
    }


    public String getError() {
        SeleniumHelper.waitForVisibility(error, driver);
        return error.getText();
    }
}
