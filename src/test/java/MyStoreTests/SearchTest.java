package MyStoreTests;

import Base.BrowserFactory;
import Base.Helper;
import MyStorePages.Navigation;
import MyStorePages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {

    public Navigation navigation;

    private String productName = "Blouse";

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        WebDriver driver = BrowserFactory.startBrowser(Helper.myStoreURL);
        navigation = new Navigation(driver);
    }

    @Test(groups = {"myStore-all"})
    public void searchFunctionalityTest(){
        navigation.enterValueInSearchField(productName)
        .clickSearchButton()
        .verifySearchedWord(productName)
        .mouseHoverProduct(productName)
        .clickAddToCartButton()
        .verifyAddedToCartImageIsPresent(productName);
    }
}
