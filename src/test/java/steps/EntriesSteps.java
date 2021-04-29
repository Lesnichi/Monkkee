package steps;

//import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import pages.EntriesPage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class EntriesSteps {
    WebDriver driver;

    public EntriesSteps(WebDriver driver) {
        this.driver = driver;
    }

    //    @Step("Login by user: '{user}'")
    public void createEntry(String text) {
        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.isPageOpened();
        entriesPage.createNewEntry("Text1");
        entriesPage.backToEntries();
    }

    public void openOneEntry() {
        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.isPageOpened();
        entriesPage.getEntryByIndex(1).click();
    }
}
