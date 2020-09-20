package lib;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Log;

import java.nio.file.Paths;
import java.util.HashMap;


public class DriverFactory {
    private Log log= new Log();
    public WebDriver getDriver() {
        String browser = System.getProperty("browser");
        String workingDir = System.getProperty("user.dir");
        String path = workingDir+"/src/main/resources/drivers";
        if (browser == null)
            browser = "chrome";
        log.info("WebDriver instance for browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            String currentPath = Paths.get(workingDir).toAbsolutePath().toString();
            String downloadFilepath =currentPath+"\\src\\main\\resources\\download";
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            System.setProperty("webdriver.chrome.driver", path+"/chromedriver.exe");
            return new ChromeDriver(cap);
        }
        else if (browser.equalsIgnoreCase("ie"))
            return new InternetExplorerDriver();
        else {
            return new FirefoxDriver();
        }
    }

}
