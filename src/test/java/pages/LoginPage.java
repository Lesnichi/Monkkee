package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;


public class LoginPage extends BasePage {

    public static final String URL_LOGIN_PAGE = "https://my.monkkee.com";
    private final By LOGIN_INPUT = By.id("login");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.className("btn-text-content");
    private final By SUBMIT_REMINDER_BUTTON = By.name("commit");
    private final By CANCEL_BUTTON = By.xpath("//div[contains(text(), 'Cancel')]");
    // private final By REGISTER_BUTTON = By.xpath("//div[@class='login-links']/a[contains(text(), 'Register')]");
    private final By SEND_PASSWORD_REMINDER_BUTTON = By.xpath("//div[@class='login-links']/a[contains(text(), 'Send password reminder')]");
    private final By TEXT_FIELD = By.xpath("//*[contains(text(), 'If the email address you entered')]");
    private final By EMAIL_INPUT = By.id("email");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Step("Opening login page")
    public void open() {
        driver.get(URL_LOGIN_PAGE);
    }

    @Step("Logging process with data: username - {userName}; password - {password}")
    public void login(String userName, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        try {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(CANCEL_BUTTON).click();
        } catch (NoSuchElementException exception) {
            System.out.println("Бесючее сообщение об ошибке появилось");
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void sendPasswordReminder(String email) {
        driver.findElement(SEND_PASSWORD_REMINDER_BUTTON).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(SUBMIT_REMINDER_BUTTON).click();
    }

    public String getTextForSuccessfullyPasswordHint() {
        return driver.findElement(TEXT_FIELD).getText();
    }
}
