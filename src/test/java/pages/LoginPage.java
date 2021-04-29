package pages;

import org.openqa.selenium.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class LoginPage extends BasePage {

    public static final String URL_LOGIN_PAGE = "https://my.monkkee.com";
    private final By LOGIN_INPUT = By.id("login");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.className("btn-text-content");
    private final By LABEL = By.id("monkkee-monk");
    private final By CANCEL_BUTTON = By.xpath("//div[contains(text(), 'Cancel')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL_LOGIN_PAGE);
    }

    public void login(String userName, String password) {
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        try {
            driver.findElement(CANCEL_BUTTON).click();
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
        }
    }
}
