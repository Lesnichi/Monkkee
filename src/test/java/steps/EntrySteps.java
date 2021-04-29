package steps;

//import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import pages.EntriesPage;
import pages.NewEntryModal;

public class EntrySteps {
    WebDriver driver;

    public EntrySteps(WebDriver driver) {
        this.driver = driver;
    }

//    @Step("Login by user: '{user}'")
    public void createEntry(String text) {
        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.isPageOpened();
        entriesPage.createNewEntry("Text1");
        entriesPage.backToEntries();
    }

    public void deleteEntry() {
        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.getEntryByIndex(1);
        NewEntryModal newEntryModal = new NewEntryModal(driver);
        newEntryModal.deleteEntry();
    }
}
