package Helpers.Pages;

import Helpers.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends BasePage {
    private final By oldPasswordInput = By.id("OldPassword");
    private final By newPasswordInput = By.id("NewPassword");
    private final By confirmPasswordInput = By.id("ConfirmNewPassword");
    private final By submitButton = By.xpath("//input[contains(@value, 'password')]");

    public void changePassword(String oldPassword, String newPassword, WebDriver driver) {
        fillOutField(driver, oldPasswordInput, oldPassword);
        fillOutField(driver, newPasswordInput, newPassword);
        fillOutField(driver, confirmPasswordInput, newPassword);
        Util.click(submitButton, driver);
    }
}
