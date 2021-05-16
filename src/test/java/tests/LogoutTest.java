package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import tests.base.Retry;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Log Out")
    public void logout() {
        loginPage.open();
        loginPage.login(login, password);
        entriesPage.isPageOpened();
        entriesPage.logout();
        assertTrue(new LoginPage(driver).isPageOpened(), "Main page was not opened");
    }
}
