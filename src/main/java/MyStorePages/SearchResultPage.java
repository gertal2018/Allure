package MyStorePages;

import Base.BaseUI;
import Base.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BrowserFactory {

    BaseUI ui;

    public SearchResultPage(WebDriver driver){
        super(driver);
        ui = new BaseUI(driver);
    }

    @FindBy(xpath = "//h1/span[@class='lighter']")
    WebElement searchResultText;

    @FindBy(xpath = "//li[contains(@class,'hovered')]//span[.='Add to cart']")
    WebElement addToCartButton;

    public SearchResultPage verifySearchedWord(String value){
        ui.verifyElementText(searchResultText, "Searched Result", "\""+value.toUpperCase()+"\"");
        return this;
    }

    public SearchResultPage mouseHoverProduct(String productName){
        WebElement productImage = driver.findElement(By.xpath("//img[@title='"+productName+"']"));
        ui.mouseHoverElement(productImage);
        return this;
    }

    public SearchResultPage clickAddToCartButton(){
        ui.clickOnElement(addToCartButton, "Add to Cart Button");
        return this;
    }
}
