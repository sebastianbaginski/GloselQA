package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.taniaksiazka.utils.SeleniumHelper;

public class HomePage {

    protected WebDriver driver;
    @FindBy(className = "user-not-logged")
    private WebElement userBox;
    @FindBy(id = "CookieX")
    private WebElement cookieCloseButton;
    @FindBy(id = "inputSearch")
    private WebElement inputSearch;
    @FindBy(xpath = "//button[contains(text(),'Szukaj')]")
    private WebElement searchButton;
    @FindBy(xpath = "//*[@id='tools']/li/a")
    private WebElement contactBtn;
    @FindBy(className = "user")
    private WebElement userBoxAfterLogIn;
    @FindBy(className = "arrow")
    private WebElement categoryButton;
    /* @FindBy(partialLinkText = "Beletrystyka")
     private WebElement booksButton;*/
    @FindBy(id = "mcct-540")
    private WebElement booksButton;
    @FindBy(id = "mcct-5249")
    private WebElement booksButton2;
    @FindBy(partialLinkText = "eBooki")
    private WebElement ebooksButton;
    @FindBy(id = "inputSearch")
    private WebElement searchEbook;

    @FindBy(tagName = "html")
    private WebElement htmlE;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LogInPage clickToLogInButton() {
        userBox.click();
        return new LogInPage(driver);
    }

    public HomePage closeCookieBar() {
        SeleniumHelper.executorClick(cookieCloseButton, driver);
        SeleniumHelper.waitForInvisible(cookieCloseButton, driver);
        return this;
    }

    public SearchPage searchProduct(String phrase) {
        inputSearch.sendKeys(phrase);
        searchButton.click();
        return new SearchPage(driver);
    }

    public String giveHtml() {
        return htmlE.getAttribute("outerHTML");
    }

    public CustomerContactPage goToCustomerContactPage() {
        contactBtn.click();
        return new CustomerContactPage(driver);
    }

    public String checkUserBox() {
        SeleniumHelper.waitForVisibility(userBoxAfterLogIn, driver);
        return userBoxAfterLogIn.getText();
    }

    public HomePage hoverToCategory(WebDriver driver) {
        SeleniumHelper.waitForVisibility(categoryButton, driver);
        Actions action = new Actions(driver);
        action.moveToElement(categoryButton).build().perform();
        return this;
    }

    public ProductsPage chooseBooksCategory(WebDriver driver) {
        SeleniumHelper.waitForVisibility(booksButton, driver);
        booksButton.click();
        return new ProductsPage(driver);
    }

    public ProductsPage chooseBooksCategory2(WebDriver driver) {
        SeleniumHelper.waitForVisibility(booksButton, driver);
        booksButton2.click();
        return new ProductsPage(driver);
    }



    public ProductsPage chooseEbooksCategory(WebDriver driver) {
      /*  SeleniumHelper.waitForVisibility(ebooksButton, driver);
        ebooksButton.click();*/
        searchEbook.click();
        searchEbook.sendKeys("ebooki");
        searchEbook.submit();
        return new ProductsPage(driver);
    }

}