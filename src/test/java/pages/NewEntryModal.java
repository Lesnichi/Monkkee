package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class NewEntryModal extends BasePage {

    public static final By EDIT_TABLE = By.id("editable");
    public static final By DELETE_ENTRY_BUTTON = By.id("delete-entry");
    public static final By BACK_BUTTON = By.id("back-to-overview");

    public static final String URL_ENTRIES_PAGE = "https://my.monkkee.com/#/entries";

    public NewEntryModal(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL_ENTRIES_PAGE);
    }

    public void fillText(String text) {
        driver.findElement(EDIT_TABLE).sendKeys(text);
    }

    public void backToEntries() {
        driver.findElement(BACK_BUTTON).click();
    }

    @Step("Delete onr entry")
    public void deleteEntry() {
        driver.findElement(DELETE_ENTRY_BUTTON).click();
        Alert alert = wait.until(alertIsPresent());
        alert.accept();
    }
}
