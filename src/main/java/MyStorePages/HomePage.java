package MyStorePages;

import Base.BaseUI;
import Base.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BrowserFactory {

    BaseUI ui;

    public HomePage(WebDriver driver){
        super(driver);
        ui = new BaseUI(driver);
    }


}
