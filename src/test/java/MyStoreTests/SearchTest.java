package MyStoreTests;

import Base.BrowserFactory;
import Base.Helper;
import MyStorePages.Navigation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {

    Navigation navigation;

    String productName = "Blouse";

    @BeforeMethod()
    public void setup(){
        WebDriver driver = BrowserFactory.startBrowser(Helper.myStoreURL);
        navigation = new Navigation(driver);
    }

    @Test(groups = {"myStore_all"})
    public void searchFunctionalityTest(){
        navigation.enterValueInSearchField(productName)
        .clickSearchButton()
        .verifySearchedWord(productName)
        .mouseHoverProduct(productName)
        .clickAddToCartButton();
    }
}
