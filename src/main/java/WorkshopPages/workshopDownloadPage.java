package WorkshopPages;

import Base.BaseUI;
import Base.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class workshopDownloadPage extends BrowserFactory{

    BaseUI ui;

    public workshopDownloadPage(WebDriver driver){
        super(driver);
        ui = new BaseUI(driver);
    }

    @FindBy(name="url")
    WebElement searchBar;

    @FindBy(xpath = "//input[@value='Download']")
    WebElement downloadButton;

    @FindBy(xpath="//a[contains(.,'Download')]")
    WebElement fileName;

    @FindBy(xpath = "//div[@id='result']//a")
    WebElement downloadLink;

    @FindBy(id="steamdownload")
    WebElement steamDownloadButton;

    public workshopDownloadPage enterTextIntoSearchBar(String text){
        ui.enterTextIntoElement(searchBar, "Search Bar", text);
        return this;
    }

    public workshopDownloadPage clickDownloadButton(){
        ui.clickOnElement(downloadButton, "Download Button");
        return this;
    }

    public workshopDownloadPage clickDownloadLink(){
        ui.clickOnElement(downloadLink, "Download Link");
        return this;
    }

    public workshopDownloadPage getModName(){
        ui.getElementAttributeText(fileName, "title");
        return this;
    }

    public workshopDownloadPage clickSteamDownloadButton(){
        ui.clickOnElement(steamDownloadButton, "Steam Download Button");
        return this;
    }

}
