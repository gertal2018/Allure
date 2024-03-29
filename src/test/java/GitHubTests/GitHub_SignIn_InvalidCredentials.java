package GitHubTests;

import Base.BrowserFactory;
import Base.Helper;
import Base.Reporter;
import GitHubPages.SignInPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GitHub_SignIn_InvalidCredentials {

    private String validEmail = Helper.GitHubEmail;
    private String validPassword = Helper.GitHubPassword;
    private String validUsername = Helper.GitHubUsername;
    private String invalidPassword = "invalidPassword";
    private String invalidEmail = "invalidEmail";
    private String invalidUsername = "invalidUsername";
    private String emptyString = "";

    public SignInPage signInPage;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        WebDriver driver = BrowserFactory.startBrowser(Helper.URL);
        signInPage = new SignInPage(driver);
    }

    @Description("Login without entering credentials")
    @Test(priority = 0, groups = {"all","invalid-regression"})
    @Severity(SeverityLevel.NORMAL)
    public void SignIn_WithoutCredentialsTest() {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(emptyString)
                .enterTextToPasswordField(emptyString)
                .clickSignInButton();
        signInPage.verifyErrorMessageAppears();
    }

    @Description("Login with valid email and empty password")
    @Test(priority = 1, groups = {"all","invalid-regression"})
    @Severity(SeverityLevel.NORMAL)
    public void SignIn_WithValidEmail_EmptyPasswordTest() {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(validEmail)
                .enterTextToPasswordField(emptyString)
                .clickSignInButton();
        signInPage.verifyErrorMessageAppears();
    }

    @Description("Login with empty email and valid password")
    @Test(priority = 2, groups = {"all","invalid-regression"})
    @Severity(SeverityLevel.NORMAL)
    public void SignIn_WithEmptyEmail_ValidPasswordTest() {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(emptyString)
                .enterTextToPasswordField(validPassword)
                .clickSignInButton();
        signInPage.verifyErrorMessageAppears();
    }

    @Description("Login with valid email and invalid password")
    @Test(priority = 3, groups = {"all","invalid-regression"})
    @Severity(SeverityLevel.NORMAL)
    public void SignIn_WithValidEmail_InvalidPasswordTest() {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(validEmail)
                .enterTextToPasswordField(invalidPassword)
                .clickSignInButton();
        signInPage.verifyErrorMessageAppears();
    }

    @Description("Login with valid username and invalid password")
    @Test(priority = 4, groups = {"all","invalid-regression"})
    @Severity(SeverityLevel.NORMAL)
    public void SignIn_WithValidUsername_InvalidPasswordTest() {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(validUsername)
                .enterTextToPasswordField(invalidPassword)
                .clickSignInButton();
        signInPage.verifyErrorMessageAppears();
    }

    @Description("Login with invalid email and valid password")
    @Test(priority = 5, groups = {"all","invalid-regression"})
    @Severity(SeverityLevel.NORMAL)
    public void SignIn_WithInvalidEmail_ValidPasswordTest() {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(invalidEmail)
                .enterTextToPasswordField(validPassword)
                .clickSignInButton();
        signInPage.verifyErrorMessageAppears();
    }

    @Description("Login with invalid username and valid password")
    @Test(priority = 6, groups = {"all","invalid-regression"})
    @Severity(SeverityLevel.NORMAL)
    public void SignIn_WithInvalidUsername_ValidPasswordTest() {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(invalidUsername)
                .enterTextToPasswordField(validPassword)
                .clickSignInButton();
        signInPage.verifyErrorMessageAppears();
    }

    @AfterMethod(alwaysRun = true)
    public void finish(ITestResult iTestResult) {
        Reporter.failedTest(iTestResult);
        BrowserFactory.closeBrowser();
    }
}
