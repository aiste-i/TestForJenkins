package Helpers;

import Helpers.Pages.AddressPage;
import Helpers.Pages.LoginPage;
import Helpers.Pages.RegisterPage;
import Helpers.Entities.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {
    public static int timeoutSeconds = 20;
    private static By loginPageLocator = By.xpath("/descendant::a[@href='/login']");
    private static final By registerPageLocator = By.xpath("/descendant::input[@value='Register']");


    public static void createUser(User user, WebDriver driver) {
        click(loginPageLocator, driver);
        click(registerPageLocator, driver);
        new RegisterPage().registerUser(user, driver);
        click(By.xpath("/descendant::input[@value='Continue']"), driver);
    }

    public static void login(User user, WebDriver driver) {
        click(loginPageLocator, driver);
        new LoginPage().login(user, driver);
    }

    public static void logout(WebDriver driver){
        click(By.xpath("/descendant::a[@href='/logout']"), driver);
    }

    public static void addItemByNameToCart(String itemName, WebDriver driver) {
        var itemButton = findElement(By.xpath("/descendant::div[@class='product-item'][descendant::a[contains(text(), '%s')]]/descendant::input[@value='Add to cart']".formatted(itemName)), driver);
        click(itemButton, driver);
    }

    public static void navigateToCart(WebDriver driver) {
        click(By.xpath("/descendant::a[@href='/cart'][ancestor::div[@class='header-links']]"), driver);
    }

    public static void fillOutAddress(WebDriver driver) {
        new AddressPage().fillOutAddress(driver);
    }

    public static void clickContinue(String section, WebDriver driver) {
        click(By.xpath("/descendant::input[@type='button'][ancestor::li[@id='opc-%s']]".formatted(section)), driver);
    }

    public static By bySection(String option) {
        return new By.ByXPath(String.format("/descendant::div[contains(@class, 'side')]/descendant::a[@href='/%s']", option));
    }

    public static void click(By locator, WebDriver driver) {
        var element = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));

        element.click();
        loader(driver);
    }

    public static void click(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));

        element.click();
        loader(driver);
    }

    public static void loader(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(new By.ByXPath("//*[contains(@class, 'ajax-loading')]")));
    }

    public static WebElement findElement(By locator, WebDriver driver) {
        var element =  new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        scroll(element, driver);
        return element;
    }

    public static boolean isDisplayed(By locator, WebDriver driver) {
        try{
            var element =  new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public static void scroll(WebElement element, WebDriver driver) {
        new Actions(driver).scrollToElement(element).perform();
    }
}
