package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BaseUI extends BrowserFactory {

    public BaseUI(WebDriver driver) {
        super(driver);
    }

    public void enterTextIntoElement(WebElement element, String elementName, String valueToEnter) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollIntoView(element);
        verifyElementIsPresentOnThePage(element, elementName);
        System.out.println("Entering --" + valueToEnter + "-- in <<" + elementName + ">>");
        element.clear();
        element.sendKeys(valueToEnter);

    }

    public void verifyElementIsPresentOnThePage(WebElement element, String elementName) {
        System.out.println("Searching for <<" + elementName + ">>");
        if (element != null) {
            String message = "Pass - Element <<" + elementName + ">> has been found";
            System.out.println(message);
        } else {
            String message = "Fail - Element <<" + elementName + ">> could not be found";
            System.out.println(message);
            Assert.fail(message);
        }
    }

    public void clickOnElement(WebElement element, String elementName) {
        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            String message = "FAIL - Element <<" + elementName + ">> is not clickable.";
            System.out.println(message);
            Assert.fail(message);
        }

        if (element != null) {
            element.click();
            System.out.println("Clicking on <<" + elementName + ">>");

        }

    }

    public void verifyElementText(WebElement element, String elementName, String valueToFerify) {
        verifyElementIsPresentOnThePage(element, elementName);
        if (element.getText().equals(valueToFerify)) {
            System.out.println("Pass - <<" + elementName + ">> has expected text --" + valueToFerify + "--");
        } else {
            String message = "Fail - expected text for <<" + elementName + ">> was --" + valueToFerify + "-- but actual text is --" + element.getText() + "--";
            System.out.println(message);
            Assert.fail(message);
        }
    }

    public void verifyElementPartialText(WebElement element, String elementName, String valueToFerify) {
        verifyElementIsPresentOnThePage(element, elementName);
        if (element.getText().contains(valueToFerify)) {
            System.out.println("Pass - <<" + elementName + ">> contains expected text --" + valueToFerify + "--");
        } else {
            String message = "Fail - expected partial text for <<" + elementName + ">> was --" + valueToFerify + "-- but actual text is --" + element.getText() + "--";
            System.out.println(message);
            Assert.fail(message);
        }
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
