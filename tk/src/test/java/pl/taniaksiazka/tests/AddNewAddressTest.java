package pl.taniaksiazka.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.taniaksiazka.models.NewAddressCustomer;
import pl.taniaksiazka.pages.AddressBookPage;
import pl.taniaksiazka.pages.HomePage;

public class AddNewAddressTest extends BaseTest {
    @Test
    public void addNewAddress() {

        NewAddressCustomer newAddressCustomer = new NewAddressCustomer();

        int sizeListBefore = new HomePage(driver)

                .closeCookieBar()
                .clickToLogInButton()
                .logIn("damian.mucus+test1@arete33.pl", "testerzy123")
                .chooseAddressBook(driver)
                .sizeAddressListBeforeAdd();


        int sizeListAfter = new AddressBookPage(driver)
                .addNewAddress(newAddressCustomer);

        Assert.assertEquals(sizeListBefore + 1, sizeListAfter);
    }
}
