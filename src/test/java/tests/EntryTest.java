package tests;

import org.testng.annotations.Test;
import pages.EntriesPage;

import static org.testng.Assert.assertTrue;

public class EntryTest extends BaseTest {

    String login = "tms-qa@yandex.ru";
    String password = "tms09AQA";


    @Test(description = "Create new Entry")
    public void createNewEntry() {
        loginSteps.login(login, password);
        entriesSteps.createEntry("Text 1");
        }

    @Test(description = "Delete Entry")
    public void deleteEntry() {
        loginSteps.login(login, password);
        entriesSteps.openOneEntry();
        entrySteps.deleteEntry();
    }

}
