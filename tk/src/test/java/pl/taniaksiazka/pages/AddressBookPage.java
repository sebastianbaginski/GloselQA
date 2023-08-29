package pl.taniaksiazka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.taniaksiazka.models.NewAddressCustomer;

import java.util.List;

public class AddressBookPage {

    protected WebDriver driver;
    @FindBy(linkText = "dodaj nowy adres")
    private WebElement addNewAddressButton;
    @FindBy(id = "inputName")
    private WebElement inputName;
    @FindBy(id = "inputLastName")
    private WebElement inputLastName;
    @FindBy(id = "UchoCompany")
    private WebElement inputCompany;
    @FindBy(id = "inputNumber")
    private WebElement inputNumber;
    @FindBy(id = "inputZipcode")
    private WebElement inputZipcode;
    @FindBy(id = "inputCity")
    private WebElement inputCity;
    @FindBy(id = "selectCountry")
    private WebElement listOfCountries;
    @FindBy(id = "inputPhone")
    private WebElement inputPhone;
    @FindBy(xpath = "//button[contains(text(),'Zapisz adres')]")
    private WebElement acceptButton;
    @FindBy(name = "SelectedAddress")
    private List<WebElement> addressList;
    @FindBy(className = "dialog-close-btn")
    private WebElement newsletter;

    public AddressBookPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void fillData(NewAddressCustomer newAddressCustomer) {
        inputName.sendKeys(newAddressCustomer.getFirstName());
        inputLastName.sendKeys(newAddressCustomer.getLastName());
        inputCompany.sendKeys(newAddressCustomer.getCompany());
        inputNumber.sendKeys(newAddressCustomer.getStreet() + " " + newAddressCustomer.getStreetNumber());
        inputZipcode.sendKeys(newAddressCustomer.getZipCode());
        inputCity.sendKeys(newAddressCustomer.getCity());

        Select country = new Select(listOfCountries);
        country.selectByVisibleText(newAddressCustomer.getCountry());

        inputPhone.sendKeys(newAddressCustomer.getPhone());
    }

    public int addNewAddress(NewAddressCustomer newAddressCustomer) {
/*
        newsletter.click();
*/
        addNewAddressButton.click();
        fillData(newAddressCustomer);
        acceptButton.click();
        return addressList.size();
    }

    public int sizeAddressListBeforeAdd() {
        return addressList.size();
    }
}