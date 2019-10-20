package GitHubPages;

import Base.BaseUI;
import Base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BrowserFactory {

    public BaseUI baseUI;

    public HomePage(WebDriver myDriver) {
        super(myDriver);
        baseUI = new BaseUI(driver);
    }

    @FindBy(xpath = "//summary/img[@class='avatar']")
    WebElement headerProfileIcon;

    @FindBy(xpath = "//a[@role='menuitem']/strong")
    WebElement headerProfileUsernameLabel;

    @Step("Clicking on profile icon in header")
    public HomePage clickHeaderProfileIcon() {
        baseUI.clickOnElement(headerProfileIcon, "Header Profile Icon");
        return this;
    }

    @Step("Verify username: {0}")
    public HomePage verifyUsername(String username){
        baseUI.verifyElementText(headerProfileUsernameLabel, "Username label", username);
        return this;
    }



}
