package tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import lib.DriverFactory;
import pages.HomePage;
import utils.Log;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    private static final String URL = "https://demoqa.com/";

    public WebDriver driver = null;
    private static final long IMPLICIT_TIME = 5;
    private Log logger= new Log();
    public HomePage homepage= new HomePage(driver);



    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        logger.info("Setup");
        DriverFactory d= new DriverFactory();
        driver = d.getDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, SECONDS);
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        logger.info("Teardown.");
        if (driver != null)
            driver.quit();
    }


}
