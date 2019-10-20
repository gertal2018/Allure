package Base;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    protected static WebDriver driver;
    public static WebDriverWait wait;
    public static int defaultWaitTime = 10;
    public static int defaultImplicitWaitTime = 30;
    public static String browserName = System.getProperty("browser");//chrome, firefox, explorer, edge, opera

    public BrowserFactory(WebDriver myDriver) {
        this.driver = myDriver;
        PageFactory.initElements(driver, this);
    }

    public static WebDriver startBrowser(String URL) {

        String browser = "";

        if(browserName == null){
            browserName = "firefox";
        }

        if (browserName.equalsIgnoreCase("chrome")) {
           // WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", Helper.rootPath + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            browser = "Google Chrome";
        } else if (browserName.equalsIgnoreCase("firefox")) {
           // WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", Helper.rootPath + "\\src\\main\\resources\\geckodriver64.exe");
            driver = new FirefoxDriver();
            browser = "Mozilla FireFox";
        } else if (browserName.equalsIgnoreCase("explorer")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            browser = "Internet Explorer";
        } else if(browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            browser = "Microsoft Edge";
        } else if(browserName.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            browser = "Opera";
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
