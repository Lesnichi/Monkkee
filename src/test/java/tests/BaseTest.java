package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.EntriesPage;
import pages.LoginPage;
import pages.NewEntryPage;
import pages.SettingsPage;
import tests.base.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    String login = "tms-qa@yandex.ru";
    String password = "tms09AQA";
    String alias = "aliasqa09";

    WebDriver driver;
    LoginPage loginPage;
    EntriesPage entriesPage;
    NewEntryPage newEntryModal;
    SettingsPage settingsPage;

    @BeforeMethod(description = "Opening browser")
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        entriesPage = new EntriesPage(driver);
        newEntryModal = new NewEntryPage(driver);
        settingsPage = new SettingsPage(driver);

        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDow() {
        if (driver != null) {
            driver.quit();
        }
    }
}