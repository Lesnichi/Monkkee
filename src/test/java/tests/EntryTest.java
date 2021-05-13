package tests;

import org.testng.annotations.Test;

public class EntryTest extends BaseTest {

    String login = "tms-qa@yandex.ru";
    String password = "tms09AQA";

    @Test(description = "Creation new Entry")
    public void createNewEntry() {
        loginPage.open();
        loginPage.login(login, password);
        entriesPage.isPageOpened();
        entriesPage.createNewEntry("Text1");
        entriesPage.backToEntries();
    }

    @Test(description = "Delete Entry")
    public void deleteEntry() {
        loginPage.open();
        loginPage.login(login, password);
        entriesPage.isPageOpened();
        entriesPage.createNewEntry("Text1");
        entriesPage.backToEntries();
        entriesPage.getEntryByIndex(1).click();
        newEntryModal.deleteEntry();
    }

}
