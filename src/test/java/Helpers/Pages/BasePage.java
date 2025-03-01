package Helpers.Pages;

import Helpers.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    void fillOutField(WebDriver driver, By locator, String value) {
        var input = Util.findElement(locator, driver);
        input.clear();
        input.sendKeys(value);
    }

    void selectOption(WebDriver driver, By locator, String option) {
        var element  = Util.findElement(locator, driver);
        var select = new Select(element);
        select.selectByVisibleText(option);
    }
}
