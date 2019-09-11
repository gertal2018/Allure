package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    protected static WebDriver driver;
    public static WebDriverWait wait;
    public static int defaultWaitTime = 10;
    public static int defaultImplicitWaitTime = 30;
    public static String browserName = System.getProperty("browser");//chrome, firefox

    public BrowserFactory(WebDriver myDriver) {
        this.driver = myDriver;
        PageFactory.initElements(driver, this);
    }

    public static WebDriver startBrowser(String URL) {

        String browser = "";

        if(browserName == null){
            browserName = "chrome";
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            browser = "Google Chrome";
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            browser = "Mozila FireFox";
        }

        System.out.println("Opening --" + URL + "-- on " + browser + " browser");
        driver.manage().timeouts().implicitlyWait(defaultImplicitWaitTime, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, defaultWaitTime);

        driver.manage().window().maximize();
        driver.get(URL);

        return driver;
    }

    public static void closeBrowser() {
        driver.quit();
    }
}
