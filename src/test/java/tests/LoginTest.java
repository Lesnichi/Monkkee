package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    String login = "tms-qa@yandex.ru";
    String password = "tms09AQA";

    @Test(retryAnalyzer = Retry.class, description = "Log In")
    public void login() {
        loginPage.open();
        loginPage.login(login, password);
        assertTrue(new EntriesPage(driver).isPageOpened(), "Main page was not opened");
    }

    @Test(description = "Send reminder")
    public void sendReminder() {
        loginPage.open();
        loginPage.sendPasswordReminder(login);
        Assert.assertEquals(loginPage.getTextForSuccessfullyPasswordHint(), "If the email address you entered is recognised," +
                " an email with a password hint will be sent to it.", "Hint didn't send");
    }

}
