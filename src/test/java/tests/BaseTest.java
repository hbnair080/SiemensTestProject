package tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import lib.DriverFactory;
import pages.ElementsPage;
import pages.HomePages;
import pages.WebElementPage;
import utils.Log;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    private static final String URL = "https://demoqa.com/";

    public WebDriver driver = null;
    private static final long IMPLICIT_TIME = 30;
    private Log logger= new Log();
    public HomePages homepage;
    public ElementsPage elementspage;
    public WebElementPage webelementpage;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        logger.info("Setup");
        DriverFactory d= new DriverFactory();
        driver = d.getDriver();
        logger.info("Intialize");
        homepage= new HomePages(driver);
        elementspage= new ElementsPage(driver);
        webelementpage= new WebElementPage(driver);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        homepage
                .verifyHomePageLoad()
                .verifyElementLoad();

    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        logger.info("Teardown.");
        if (driver != null)
            driver.quit();
    }


}
