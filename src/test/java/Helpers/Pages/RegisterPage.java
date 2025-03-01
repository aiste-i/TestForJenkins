package Helpers.Pages;

import Helpers.Entities.User;
import Helpers.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    private final By firstNameInput = By.id("FirstName");
    private final By lastNameInput = By.id("LastName");
    private final By emailInput = By.id("Email");
    private final By passwordInput = By.id("Password");
    private final By confirmPasswordInput = By.id("ConfirmPassword");
    private final By registerButton = By.id("register-button");

    public void registerUser(User user, WebDriver driver) {
        fillOutField(driver, firstNameInput ,user.FirstName);
        fillOutField(driver, lastNameInput ,user.LastName);
        fillOutField(driver, emailInput ,user.Email);
        fillOutField(driver, passwordInput ,user.Password);
        fillOutField(driver, confirmPasswordInput, user.Password);
        Util.click(registerButton, driver);
    }
}
