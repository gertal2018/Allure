package SKPages;

import Base.BaseUI;
import Base.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SK_Page extends BrowserFactory{

    public BaseUI baseUI;

    public SK_Page(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    @FindBy(xpath = "//ul[@class='lcp_catlist']//a")
    List<WebElement> gameLinks;

    @FindBy(xpath = "//a[@class='lcp_nextlink']")
    WebElement nextPage;

    @FindBy(xpath = "//a[@class='lcp_nextlink']/../preceding-sibling::li[1]")
    WebElement lastPage;

    public SK_Page searchForAGame(String gameName) {
        String allGames = "Games Found:";
        int openNewTabs = 1;
        int numberOfPages = Integer.parseInt(lastPage.getText()) - 1;
        ArrayList<String> listOfFoundGames = new ArrayList();
        for (int i = 0; i < numberOfPages; i++) {
            for (WebElement webElement : gameLinks) {
                if(webElement.getText().toLowerCase().contains(gameName)) {
                    System.out.println("Found "+webElement.getText()+" Game - Opening in new tab");
                    System.out.println("URL "+webElement.getAttribute("href"));
                    allGames += "\n" + webElement.getText();
                    //baseUI.clickOnElement(webElement, webElement.getText()+" link");
                    listOfFoundGames.add(webElement.getAttribute("href"));
                }
            }

            clickNextPageIfPresent();
        }

        for (String string : listOfFoundGames) {
            System.out.println("Opening new tab");
            BrowserFactory.openNewTab();
            System.out.println("Switching to " + openNewTabs + " tab");
            BrowserFactory.swithToTab(openNewTabs);
            System.out.println("Entering " + string + " url");
            BrowserFactory.enterURL(string);
            openNewTabs++;
        }
        System.out.println(allGames);
        return this;
    }

    public SK_Page clickNextPageIfPresent() {
        BrowserFactory.changeDefaultWaitTime(2);
        WebElement element = BrowserFactory.driver.findElement(By.xpath("//a[@class='lcp_nextlink']"));
        if(element != null) {
            baseUI.clickOnElement(element, "Next Page");
        }
        BrowserFactory.returnToDefaultWaitTime();
        return this;
    }
}
