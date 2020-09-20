package lib;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.util.function.Function;

import static org.testng.Assert.*;

public class Services {


    private Log log= new Log();
    public static WebDriver driver;
    public SikuliFunctions s= SikuliFunctions.getInstance();
    public FileFunctions filefunctions= new FileFunctions();


    public Services(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver giveDriver()
    {
        return driver;
    }


    public By findElementByType(String type,String locator) {
        By element = null;
        if (type.equalsIgnoreCase("xpath")) {
            element = By.xpath(locator);
        }
        else if (type.equalsIgnoreCase("css"))
        {
            element = By.cssSelector(locator);
        }

        return (element);
    }

    public void waitForElement(String type,String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(this.findElementByType(type,locator)));
    }

    public void waitForElements(String type,String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.findElementByType(type,locator)));
    }


    public void click(String type,String locator) {
        driver.findElement(this.findElementByType(type,locator)).click();
    }

    public String text(String type,String locator) {
       return driver.findElement(this.findElementByType(type,locator)).getText();
    }


    protected void typeData(String type,String locator, String text) {
        driver.findElement(this.findElementByType(type,locator)).sendKeys(text);
    }



    //Java8 way - by same method we can pass all types of locators.
    protected void type(Function<String, By> locate, String locator, String text) {
        driver.findElement(locate.apply(locator)).sendKeys(text);
    }

    protected void assertElementPresent(String type,String locator) {
        log.info("# Verifying element.");
        assertTrue(isElementPresent(type,locator), "Element " + locator + " not found.");
    }

    protected void assertElementNotPresent(String type, String locator) {
        log.info("# Verifying element.");
        assertFalse(isElementPresent(type,locator), "Element " + locator + " is found.");
    }

    protected boolean isElementPresent(String type,String locator) {
        try {
            driver.findElement(this.findElementByType(type,locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isElementVisible(String type,String locator) {
        try {
            return driver.findElement(this.findElementByType(type,locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void assertElementVisible(String type,String locator, boolean isVisible) {
        log.info("# Verifying element visibility.");
        if (isVisible)
            assertTrue(isElementVisible(type,locator), "Element " + locator + " should be visible.");
        else
            assertFalse(isElementVisible(type,locator), "Element " + locator + " should not be visible.");
    }

    protected void assertText(String type,String locator, String expectedText) {
        log.info("Asserting Text");
        String actualText=text(type,locator);
        assertEquals(expectedText,actualText,"Expected string "+expectedText+"does not match actual string "+actualText );
    }

    protected void waitForElementVisible(String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitForElementInVisible(String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    protected WebElement getWebElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }



    protected void scrollElementIntoView(String type, String locator)
    {
        WebElement element= driver.findElement(this.findElementByType(type,locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void jsClick(String type, String locator)
    {
        WebElement element= driver.findElement(this.findElementByType(type,locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
