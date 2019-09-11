package GitHubTests;

import Base.BrowserFactory;
import Base.Helper;
import Base.Reporter;
import Pages.SignInPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class GitHub_SignIn_ValidCredentials {

    public SignInPage signInPage;

    @DataProvider(name = "validEmail")
    public Object[] getValidEmailData() {
        String[][] userData = {
                {"zakayla@fbeaveraqb.com", "Temptest1234!", "user29082019"},
                {"belecire@doc-mail.net", "TemporaryPassword1234", "tester020920019"},
                {"test","test","test"}
        };
        return userData;
    }

    @DataProvider(name = "validUsername")
    public Object[] getValidUsernameData() {
        String[][] userData = {
                {"user29082019", "Temptest1234!", "user29082019"},
                {"tester020920019", "TemporaryPassword1234", "tester020920019"}
        };
        return userData;
    }

//    @DataProvider(name = "invalidUsers")
//    public Object[] getInvalidData() {
//        String[][] userData = {
//                {"", ""},
//                {"zakayla@fbeaveraqb.com", ""},
//                {"", "Temptest1234!"},
//                {"invalidUser", "Temptest1234!"},
//                {"zakayla@fbeaveraqb.com", "invalidPassword"}
//        };
//        return userData;
//    }

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        WebDriver driver = BrowserFactory.startBrowser(Helper.URL);
        signInPage = new SignInPage(driver);
    }

//    @Description("Login scenario with invalid credentials")
//    @Test(priority = 0, dataProvider = "invalidUsers")
//    @Severity(SeverityLevel.NORMAL)
//    @DisplayName("Sign in with valid credentials test")
//    public void SignInWithInvalidCredentialsTest(String email, String password) {
//        signInPage.ClickSignInLink()
//                .enterTextToEmailField(email)
//                .enterTextToPasswordField(password)
//                .clickSignInButton();
//        signInPage.verifyErrorMessageAppears();
//    }

    @Description("Login scenario with valid email credentials")
    @Test(priority = 1, dataProvider = "validEmail", groups = {"all","valid-regression", "test"})
    @Severity(SeverityLevel.CRITICAL)
    public void SignInWithValidEmailCredentialsTest(String email, String password, String username) {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(email)
                .enterTextToPasswordField(password)
                .clickSignInButton()
                .clickHeaderProfileIcon()
                .verifyUsername(username);
    }

    @Description("Login scenario with valid username credentials")
    @Test(priority = 2, dataProvider = "validUsername", groups = {"all","valid-regression"})
    @Severity(SeverityLevel.CRITICAL)
    public void SignInWithValidUsernameCredentialsTest(String email, String password, String username) {
        signInPage.ClickSignInLink()
                .enterTextToEmailField(email)
                .enterTextToPasswordField(password)
                .clickSignInButton()
                .clickHeaderProfileIcon()
                .verifyUsername(username);
    }

    @AfterMethod(alwaysRun = true)
    public void finish(ITestResult iTestResult) {
        Reporter.failedTest(iTestResult);
        BrowserFactory.closeBrowser();
    }

}
