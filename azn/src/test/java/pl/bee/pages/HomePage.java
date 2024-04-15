package pl.bee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.bee.utils.SeleniumHelper;


public class HomePage {

    @FindBy(id = "search_query_top")
    private WebElement inputSearch;

    @FindBy(xpath = "//*[@id='searchbox']/button")
    private WebElement searchButton;

    @FindBy(className = "til_user")
    private WebElement logInBtn;

    /*@FindBy(id = "closeCookie")
    private WebElement closeCookieButton;*/

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private WebElement closeCookieButton;

   /* @FindBy(id = "main-menu-9000")
    private WebElement menuItem;*/

    @FindBy(id = "menu-item-66")
    private WebElement menuItem;

    @FindBy(id = "menu-item-31")
    private WebElement menuItem2;

    @FindBy(id = "menu-item-62")
    private WebElement menuItem3;

    @FindBy(className = "sbcat-linker")
    private WebElement subMenuItem;
    @FindBy(id = "close-button-1454703513202")
    private WebElement closeads;

    @FindBy(xpath = "//span[contains(text(), 'KONTAKT')]")
    private WebElement contactButton;


    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


    public HomePage closeCookieBar() {
        SeleniumHelper.waitForVisibility(closeCookieButton, driver);
        SeleniumHelper.executorClick(closeCookieButton, driver);
        return new HomePage(driver);
    }

    public SearchedPage searchPhrase(String phrase) {
        inputSearch.sendKeys(phrase);
        searchButton.click();
        return new SearchedPage(driver);
    }


    public LogInPage goToLogInPage() {
        logInBtn.click();
        return new LogInPage(driver);
    }

    public String getString() {
        SeleniumHelper.waitForVisibility(logInBtn, driver);

        return logInBtn.getText();
    }


    public CustomerContactPage goToContactPage() {
        contactButton.click();
        return new CustomerContactPage(driver);
    }


    public ProductsPage chooseItem() {
      /*  Actions ac = new Actions(driver);
        ac.moveToElement(menuItem).build().perform();
        SeleniumHelper.waitForVisibility(subMenuItem, driver);
        subMenuItem.click();*/

        menuItem.click();
        return new ProductsPage(driver);
    }

    public ProductsPage chooseItem2() {

        menuItem2.click();
        return new ProductsPage(driver);
    }

    public ProductsPage chooseItem3() {

        menuItem3.click();
        SeleniumHelper.waitForVisibility(closeads,driver);
        SeleniumHelper.executorClick(closeads,driver);
        return new ProductsPage(driver);
    }



}
