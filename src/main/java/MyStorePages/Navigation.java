package MyStorePages;

import Base.BaseUI;
import Base.BrowserFactory;
import io.qameta.allure.Step;
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

    @Step("Entering {0} into search field")
    public Navigation enterValueInSearchField(String value){
        ui.enterTextIntoElement(searchField, "Search Field", value);
        return this;
    }

    @Step("Clicking search button")
    public SearchResultPage clickSearchButton() {
        ui.clickOnElement(searchButton, "Search Result Button");
        return searchResultPage;
    }
}
