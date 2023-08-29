package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.taniaksiazka.utils.SeleniumHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    protected WebDriver driver;
    @FindBy(xpath = "//div[@class='product-image']")
    private WebElement addProductToCartBtn;
    @FindBy(linkText = "dodaj do schowka")
    private WebElement addToWishListLink;
    @FindBy(xpath = "//*[@class='product-price ']")
    private List<WebElement> prices;
    @FindBy(id = "search-params-sort")
    private WebElement select;

    @FindBy (className = "dialog-close-btn")
    private WebElement newsletter;

    @FindBy(xpath = "//*[@id='AddToCartBox']/div/div[3]/form/button")
    private WebElement addToCart;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AddToCartPage chooseProduct() {
        addProductToCartBtn.click();
        addToCart.click();
        return new AddToCartPage(driver);
    }
    public AddToCartPage chooseProduct2() {
        addProductToCartBtn.click();
        return new AddToCartPage(driver);
    }

    public WishListPage addToWishList() {
        SeleniumHelper.executorClick(addToWishListLink, driver);
        return new WishListPage(driver);
    }

    public String getPriceList() {
        List<Float> newList = new ArrayList<>();
        Select s = new Select(select);
        s.selectByValue("cenarosnaco");

        for (int i = 0; i < prices.size(); i++) {
            newList.add(Float.parseFloat(prices.get(i).getText()
                    .substring(0, prices.get(i).getText().length() - 2)
                    .replace(",", ".")));
        }

        for (int i = 0; i < newList.size() - 1; i++) {
            if (newList.get(i + 1) < newList.get(i)) {
                System.out.println("Blad przy cenie " + newList.get(i + 1) + " " + newList.get(i));
                return "Test failed";
            }
        }

        return "Test Poprawny";
    }

}

