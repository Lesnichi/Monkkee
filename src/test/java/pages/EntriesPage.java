package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class EntriesPage extends BasePage {

    public static final By SETTINGS_BUTTON = By.cssSelector(".user-menu-btn");
    public static final By CREATE_AN_EMPTY_BUTTON = By.id("create-entry");
    public static final By EDIT_TABLE = By.id("editable");
    public static final By BACK_BUTTON = By.id("back-to-overview");
    public static final By ENTRY = By.cssSelector("div[ng-bind-html='entry.body']");
    public static final By ENTRY_CONTAINER = By.cssSelector(".entry-container");

    public static final String URL_ENTRIES_PAGE = "https://my.monkkee.com/#/entries";

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL_ENTRIES_PAGE);
    }

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
        driver.findElement(CREATE_AN_EMPTY_BUTTON).click();
        driver.findElement(EDIT_TABLE).sendKeys(text);
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
}
