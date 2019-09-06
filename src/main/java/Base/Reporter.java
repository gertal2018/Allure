package Base;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Reporter extends BrowserFactory {


    public Reporter(WebDriver driver) {
        super(driver);
    }

    public static void failedTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE){
            attachScreenshotToAllure(result);
        }
    }

    @Attachment(type = "image/png")
    public static byte[] attachScreenshotToAllure(ITestResult result)/* throws IOException */ {

        try {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screen);
        } catch (IOException e) {
            return null;
        }
    }
}


