package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.base.Retry;

import static org.testng.Assert.assertTrue;

public class SettingsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Log Out")
    public void logout() {
        loginPage.open();
        loginPage.login(login, password);
        entriesPage.isPageOpened();
        entriesPage.logout();
        assertTrue(new LoginPage(driver).isPageOpened(), "Main page was not opened");
    }

    @Test(description = "Send reminder")
    public void sendReminder() {
        loginPage.open();
        loginPage.sendPasswordReminder(login);
        Assert.assertEquals(loginPage.getTextForSuccessfullyPasswordHint(), "If the email address you entered is recognised," +
                " an email with a password hint will be sent to it.", "Hint didn't send");
    }
}
