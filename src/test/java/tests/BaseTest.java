package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.NewEntryModal;
import steps.EntriesSteps;
import steps.EntrySteps;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    LoginSteps loginSteps;
    EntriesSteps entriesSteps;
    EntrySteps entrySteps;

    @BeforeMethod
    public void setup(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);

        loginSteps = new LoginSteps(driver);
        entriesSteps = new EntriesSteps(driver);
        entrySteps = new EntrySteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDow() {
        if (driver != null) {
            driver.quit();
        }
    }
}
