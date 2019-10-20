package MyStorePages;

import Base.BaseUI;
import Base.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation extends BrowserFactory {

    BaseUI ui;
    HomePage homePage;
    SearchResultPage searchResultPage;

    public Navigation(WebDriver driver){
        super(driver);
        ui = new BaseUI(driver);
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @FindBy(css = "#search_query_top")
    WebElement searchField;

    @FindBy (name = "submit_search")
    WebElement searchButton;

    public void enterValueInSearchField(String value){
        ui.enterTextIntoElement(searchField, "Search Field", value);
       // return this;
    }

    public void clickSearchButton() {
        ui.clickOnElement(searchButton, "Search Result Button");
       // return searchResultPage;
    }
}
