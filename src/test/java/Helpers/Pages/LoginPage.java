package Helpers.Pages;

import Helpers.Entities.User;
import Helpers.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By emailInput = By.id("Email");
    private final By passwordInput = By.id("Password");
    private final By loginButton = By.xpath("/descendant::input[contains(@class, 'login-button')]");

    public void login(User user, WebDriver driver) {
        fillOutField(driver, emailInput, user.Email);
        fillOutField(driver, passwordInput, user.Password);
        Util.click(loginButton, driver);
    }
}
