package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SettingsPage extends BasePage {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL_SETTINGS_PAGE = "https://my.monkkee.com/#/settings/locale";
    private static final By SETTINGS_MENU = By.cssSelector(".form-control");
    private static final By LOGIN_ALIAS_MENU = By.cssSelector("[ng-class=\"cssClass('login')\"]");
    private static final By USE_ALIAS_CHECKBOX = By.cssSelector("input[id='use-alias']");
    private static final By ALIAS_INPUT = By.cssSelector("input[id='alias']");
    private static final By ALERT_SUCCESS = By.cssSelector(".alert.alert-success");
    private static final By LANGUAGE_DROPDOWN = By.name("selectLocale");
    private static final By SUBMIT_BUTTON = By.cssSelector(".btn-text-content");
    private static final By LOGOUT_BUTTON = By.cssSelector(".icon-off.icon-light");


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

    @Step("Selecting language (Deutsch)")
    public void selectLanguageDeutsch() {
        Select selectLang = new Select(driver.findElement(LANGUAGE_DROPDOWN));
        selectLang.selectByIndex(0);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    @Step("Selecting language (English)")
    public void selectLanguageEng() {
        Select selectLang = new Select(driver.findElement(LANGUAGE_DROPDOWN));
        selectLang.selectByIndex(1);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    @Step("Getting successfully result for checking")
    public String getTextForSuccessfullyLanguageChange() {
        return driver.findElement(ALERT_SUCCESS).getText();
    }

    @Step("Setting alias for account")
    public void setAlias(String aliasName) {
            driver.findElement(LOGIN_ALIAS_MENU).click();
            if (!driver.findElement(USE_ALIAS_CHECKBOX).isSelected()) {
                driver.findElement(USE_ALIAS_CHECKBOX).click();

            }
            driver.findElement(ALIAS_INPUT).clear();
            driver.findElement(ALIAS_INPUT).sendKeys(aliasName);
            driver.findElement(SUBMIT_BUTTON).click();
        }
    }
