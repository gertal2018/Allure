package Workshop;

import Base.BrowserFactory;
import Base.Helper;
import WorkshopPages.workshopDownloadPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class downloadCityAssets {

    public workshopDownloadPage downloadPage;
    private String modURL = "https://steamcommunity.com/sharedfiles/filedetails/?id=1905536921";

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        WebDriver driver = BrowserFactory.startBrowser(Helper.workshopDownloadURL);
        downloadPage = new workshopDownloadPage(driver);
    }

    @Test()
    public void downloadCitySkylinesModTest(){
        downloadPage.enterTextIntoSearchBar(modURL)
                .clickDownloadButton()
                .clickSteamDownloadButton()
                .clickDownloadLink();
    }
}
