package SKTests;

import Base.BaseUI;
import Base.BrowserFactory;
import Base.Helper;
import SKPages.SK_Page;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchForAGame {

    public SK_Page gameList;

    private String gameName = "tooth and tail";

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {
        WebDriver driver = BrowserFactory.startBrowser(Helper.SkidrowURL);
        gameList = new SK_Page(driver);
    }

    @Test
    public void SearchForAGameTest() {
        gameList.searchForAGame(gameName);

    }

    @AfterMethod(alwaysRun = true)
    public void TearDown(ITestResult results) {
        //BaseUI.takeScreenShot(results);
        //BrowserFactory.closeBrowser();
    }
}
