package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EntriesPage extends BasePage {

    private static final By SETTINGS_BUTTON = By.cssSelector(".icon-cog.icon-light");
    public static final By CREATE_AN_EMPTY_BUTTON = By.id("create-entry");
    public static final By EDIT_TABLE = By.id("editable");
    public static final By BACK_BUTTON = By.id("back-to-overview");
    public static final By ENTRY = By.cssSelector("div[ng-bind-html='entry.body']");
    public static final By ENTRY_CONTAINER = By.cssSelector(".entry-container");
    public static final By ENTRIES_CONTAINER = By.cssSelector(".model.checked[entry.id]");
    private static final By LOGOUT_BUTTON = By.cssSelector(".icon-off.icon-light");
    private static final By LOGOUT_BUTTON_POPUP = By.xpath("//div[text()='Log out']");

    public static final String URL_ENTRIES_PAGE = "https://my.monkkee.com/#/entries";

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Openning enties page")
    public void open() {
        driver.get(URL_ENTRIES_PAGE);
    }

    @Step("Checking the opening of the entries page")
    public boolean isPageOpened() {
        boolean isOpened;
        try {
            driver.findElement(SETTINGS_BUTTON);
            isOpened = true;
        } catch (NoSuchElementException exception) {
            isOpened = false;
            Assert.fail("Страница продукта не была загружена");
        }
        return isOpened;
    }

    public void createNewEntry(String text) {
        try {
            driver.findElement(CREATE_AN_EMPTY_BUTTON).click();
            driver.findElement(EDIT_TABLE).sendKeys(text);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void backToEntries() {
        driver.findElement(BACK_BUTTON).click();
    }

    public void openOneEntry() {
        driver.findElement(ENTRY).click();
    }

    public WebElement getEntryByIndex(int index) {
        return driver.findElements(ENTRY_CONTAINER).get(index);
    }

    @Step("Log out - exit from the site")
    public void logout() {
        driver.findElement(LOGOUT_BUTTON).click();
        try {
            driver.findElement(LOGOUT_BUTTON_POPUP).click();
        } catch (NoSuchElementException exception) {
            System.out.println("POPUP (logout) window appeared");
        }
    }
}