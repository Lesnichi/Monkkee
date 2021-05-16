package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SettingsPage extends BasePage {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL_SETTINGS_PAGE = "https://my.monkkee.com/#/settings/locale";
    private static final By SETTINGS_MENU = By.cssSelector(".form-control");
    private final By LOGIN_BUTTON = By.className("btn-text-content");


    @Step("Opening settings page")
    public void open() {
        driver.get(URL_SETTINGS_PAGE);
    }

    @Step("Checking the opening of the settings page")
    public boolean isPageOpened() {
        boolean isOpened;
        try {
            driver.findElement(SETTINGS_MENU);
            isOpened = true;
        } catch (NoSuchElementException exception) {
            isOpened = false;
            Assert.fail("Страница продукта не была загружена");
        }
        return isOpened;
    }

}
