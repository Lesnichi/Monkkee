package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.Retry;

public class SettingsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Selecting language")
    public void selectLanguage() {
        loginPage.open();
        loginPage.login(login, password);
        settingsPage.open();
        settingsPage.isPageOpened();
        settingsPage.selectLanguageDeutsch();
        Assert.assertEquals(settingsPage.getTextForSuccessfullyLanguageChange(), "Deine Spracheinstellung wurde erfolgreich geändert", "Language is not changed");
        settingsPage.selectLanguageEng();
        Assert.assertEquals(settingsPage.getTextForSuccessfullyLanguageChange(), "Your language has been changed successfully", "Language is not changed");

    }

    @Test(description = "Setting alias for Login")
    public void enterByAlias() {
        loginPage.open();
        loginPage.login(login, password);
        settingsPage.open();
        settingsPage.isPageOpened();
        settingsPage.setAlias(alias);
        Assert.assertEquals(settingsPage.getTextForSuccessfullyLanguageChange(), "Your settings have been saved successfully", "Alias is not accepted");
    }
}
