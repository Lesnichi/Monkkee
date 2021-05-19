package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class NewEntryPage extends BasePage {

    public static final By EDIT_TABLE = By.cssSelector(".contenteditable.cke_editable");
    public static final By DELETE_ENTRY_BUTTON = By.id("delete-entry");
    public static final By BACK_BUTTON = By.id("back-to-overview");

    public static final String URL_ENTRIES_PAGE = "https://my.monkkee.com/#/entries";

    public NewEntryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening entries page")
    public void open() {
        driver.get(URL_ENTRIES_PAGE);
    }

    @Step("Updating entry")
    public void updateText(String text) {
        driver.findElement(EDIT_TABLE).clear();
        driver.findElement(EDIT_TABLE).sendKeys(text);
        }

    @Step("Returning to all entries page entry")
    public void backToEntries() {
        driver.findElement(BACK_BUTTON).click();
    }

    @Step("Deleting current entry")
    public void deleteEntry() {
        driver.findElement(DELETE_ENTRY_BUTTON).click();
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }
}
