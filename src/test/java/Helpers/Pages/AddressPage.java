package Helpers.Pages;

import Helpers.EntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends BasePage {
    public static final By countrySelect = By.xpath("/descendant::select[@id='BillingNewAddress_CountryId']");
    public static final By cityInput = By.id("BillingNewAddress_City");
    public static final By streetInput = By.id("BillingNewAddress_Address1");
    public static final By postalCodeInput = By.id("BillingNewAddress_ZipPostalCode");
    public static final By phoneNumberInput = By.id("BillingNewAddress_PhoneNumber");

    public void fillOutAddress(WebDriver driver){
        var adddress = EntityBuilder.GetAddress();
        selectOption(driver, countrySelect, adddress.Country);
        fillOutField(driver, cityInput, adddress.City);
        fillOutField(driver, streetInput, adddress.Street);
        fillOutField(driver, postalCodeInput, adddress.PostalCode);
        fillOutField(driver, phoneNumberInput, adddress.PhoneNumber);
    }
}
