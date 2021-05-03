package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;


@Log4j2
public class LoginPage extends BasePage {

    public static final String URL_LOGIN_PAGE = "https://my.monkkee.com";
    private final By LOGIN_INPUT = By.id("login");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.className("btn-text-content");
//    private final By LABEL = By.id("monkkee-monk");
    private final By CANCEL_BUTTON = By.xpath("//div[contains(text(), 'Cancel')]");
//    private final By REGISTER_BUTTON = By.xpath("//div[@class='login-links']/a[contains(text(), 'Register')]");
//    private final By SEND_PASSWORD_REMINDER_BUTTON = By.xpath("//div[@class='login-links']/a[contains(text(), 'Send password reminder')]");

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
            driver.findElement(CANCEL_BUTTON).click();
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
        } finally {

        }
    }

    public void loginwithoutTryCatch(String userName, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
}
