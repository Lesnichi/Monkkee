package tests;

import org.testng.annotations.Test;
import pages.EntriesPage;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    String login = "tms-qa@yandex.ru";
    String password = "tms09AQA";

    @Test(description = "Log In")
    public void login() {
        loginPage.open();
        loginPage.login(login, password);
        assertTrue(new EntriesPage(driver).isPageOpened(), "Main page was not opened");
    }
}
