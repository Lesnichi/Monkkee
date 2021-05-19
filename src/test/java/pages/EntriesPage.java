package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class EntriesPage extends BasePage {

    private static final By SETTINGS_BUTTON = By.cssSelector(".icon-cog.icon-light");
    public static final By CREATE_AN_EMPTY_BUTTON = By.id("create-entry");
    public static final By EDIT_TABLE = By.cssSelector(".contenteditable.cke_editable");
    public static final By BACK_BUTTON = By.id("back-to-overview");
    public static final By ENTRY_CONTAINER = By.xpath("//div[@class='body ']");
    private static final By LOGOUT_BUTTON = By.cssSelector(".icon-off.icon-light");
    private static final By LOGOUT_BUTTON_POPUP = By.xpath("//div[text()='Log out']");
    private static final By ALL_CHECKBOX = By.cssSelector("[title='Select all']");
    public static final By DELETE_ENTRIES_BUTTON = By.id("delete-entries");


    public static final String URL_ENTRIES_PAGE = "https://my.monkkee.com/#/entries";

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening entries page")
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

    @Step("Creating entry and entering the text")
    public void createNewEntry(String text) {
        driver.findElement(CREATE_AN_EMPTY_BUTTON).click();
        Actions action = new Actions(driver);
        action.click(driver.findElement(EDIT_TABLE)).sendKeys(text).perform();
    }

    @Step("Returning to all entries page entry")
    public void backToEntries() {
        driver.findElement(BACK_BUTTON).click();
    }

    @Step("Getting entry by index")
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

    @Step("Deleting all entries from EntriesPage")
    public void deleteAllEntries() {
        driver.findElement(ALL_CHECKBOX).click();
        driver.findElement(DELETE_ENTRIES_BUTTON).click();
        driver.switchTo().alert().accept();
    }
}