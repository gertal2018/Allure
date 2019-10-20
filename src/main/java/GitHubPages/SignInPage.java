package GitHubPages;

import Base.BaseUI;
import Base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BrowserFactory {

    public BaseUI baseUI;


    public SignInPage(WebDriver myDriver) {
        super(myDriver);
        baseUI = new BaseUI(driver);
    }

    @FindBy(xpath = "//a[@href='/login']")
    WebElement SignInLink;

    @FindBy(name = "login")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "commit")
    WebElement signInButton;

    @FindBy(xpath = "//div[@class='container']")
    WebElement errorMesage;

    @Step("Clicking on Sign In Link")
    public SignInPage ClickSignInLink() {
        baseUI.clickOnElement(SignInLink, "Sign in link");
        return this;
    }

    @Step("Entering {0} into Email field")
    public SignInPage enterTextToEmailField(String email) {
        baseUI.enterTextIntoElement(usernameField, "Username or email address field", email);
        return this;
    }

    @Step("Entering {0} into Password field")
    public SignInPage enterTextToPasswordField(String password) {
        baseUI.enterTextIntoElement(passwordField, "Password field", password);
        return this;
    }

    @Step("Clicking Sign In Button")
    public HomePage clickSignInButton() {
        baseUI.clickOnElement(signInButton, "Sign in button");
        return new HomePage(driver);
    }

    @Step("Verify Sign In Error Message appears")
    public SignInPage verifyErrorMessageAppears(){
        baseUI.verifyElementPartialText(errorMesage, "Sign In error message", "Incorrect username or password.");
        return this;
    }
    
}
