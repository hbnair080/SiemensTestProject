package lib;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.Log;


public class DriverFactory {
    private Log log= new Log();

    public WebDriver getDriver() {
        String browser = System.getProperty("browser");
        String workingDir = System.getProperty("user.dir");
        String path = workingDir+"/src/resources";
        if (browser == null)
            browser = "chrome";
        log.info("WebDriver instance for browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", path+"/chromedriver.exe");
            return new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie"))
            return new InternetExplorerDriver();
        else {
            return new FirefoxDriver();
        }
    }

}
