package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EntryTest extends BaseTest {

    @Test(description = "Creation new Entry")
    public void createNewEntry() {
        loginPage.open();
        loginPage.login(login, password);
        entriesPage.isPageOpened();
        entriesPage.createNewEntry("Create new entry test");
        entriesPage.backToEntries();
    }

    @Test(description = "Deleting Entry")
    public void deleteEntry() {
        loginPage.open();
        loginPage.login(login, password);
        entriesPage.isPageOpened();
        entriesPage.createNewEntry("Deleting one entry test");
        entriesPage.backToEntries();
        entriesPage.getEntryByIndex(0).click();
        newEntryModal.deleteEntry();
    }

    @Test(description = "Updating Entry")
    public void updateEntry() {
        loginPage.open();
        loginPage.login(login, password);
        entriesPage.isPageOpened();
        entriesPage.createNewEntry("Updating test");
        entriesPage.backToEntries();
        entriesPage.getEntryByIndex(0).click();
        newEntryModal.updateText("Update text");
        newEntryModal.backToEntries();
        Assert.assertEquals(entriesPage.getEntryByIndex(0).getText(), "Update text", "Text in the entry didn't update");
    }

    @Test(description = "Delete all entries")
    public void deleteAllEntries() {
        loginPage.open();
        loginPage.login(login, password);
        entriesPage.isPageOpened();
        entriesPage.createNewEntry("Deleting all entries test");
        entriesPage.backToEntries();
        entriesPage.deleteAllEntries();
    }
}
