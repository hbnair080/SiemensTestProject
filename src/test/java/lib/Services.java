package lib;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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

    public WebElement waitForElement(String type,String locator) {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(this.findElementByType(type,locator)));
    }

    public List<WebElement> waitForElements(String type, String locator) {
        return new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.findElementByType(type,locator)));
    }

    public List<WebElement> waitForElementsVisible(String type, String locator) {
        return new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.findElementByType(type,locator)));
    }

    public WebElement findElementByParent(WebElement element, String type, String locator)
    {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(this.findElementByType(type,locator)));
        //return element.findElement(this.findElementByType(type,locator));
    }


    public Alert waitForAlert() {
       return new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
    }

    public void waitForAlertAndDismiss() {
       Alert a=this.waitForAlert();
       a.dismiss();
    }

    public void waitForAlertAndAccept() {
        Alert a=this.waitForAlert();
        a.accept();
    }

    public String alertText() {
        Alert a=this.waitForAlert();
        return a.getText();
    }

    public void alertSendKey(String text) {
        Alert a=this.waitForAlert();
         a.sendKeys(text);
    }


    public void click(String type,String locator) { this.waitForElement(type,locator).click();
    }

    public String text(String type,String locator) {
       return driver.findElement(this.findElementByType(type,locator)).getText();
    }

    protected void typeData(String type,String locator, String text) {
        driver.findElement(this.findElementByType(type,locator)).sendKeys(text);
    }

    public void switchFrames(String type,String locator) {
         driver.switchTo().frame(driver.findElement(this.findElementByType(type,locator)));
    }

    public void switchMainContent() {
        driver.switchTo().defaultContent();
    }

    protected void assertElementPresent(String type,String locator) {
        log.info("# Verifying element.");
        Assert.assertTrue(isElementPresent(type,locator), "Element " + locator + " not found.");
    }

    protected void assertElementNotPresent(String type, String locator) {
        log.info("# Verifying element.");
        Assert.assertFalse(isElementPresent(type,locator), "Element " + locator + " is found.");
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
            Assert.assertTrue(isElementVisible(type,locator), "Element " + locator + " should be visible.");
        else
            Assert.assertFalse(isElementVisible(type,locator), "Element " + locator + " should not be visible.");
    }

    protected void simpleAssertTrue(boolean value,String message) {
            Assert.assertTrue(value, message);
    }


    protected void waitForElementVisible(String type,String locator) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(this.findElementByType(type,locator)));
    }

    protected void waitForElementInVisible(String type,String locator) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(this.findElementByType(type,locator)));
    }

    protected void waitForAttributeContains(String type,String locator, String attribute, String value) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.attributeContains(this.findElementByType(type,locator),attribute,value));
    }

    protected WebElement getWebElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    protected String getPageTitle()
    {
        return driver.getTitle();
    }

    protected void scrollElementIntoView(String type, String locator)
    {
        WebElement element= driver.findElement(this.findElementByType(type,locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void switchTab() {
        log.info("Switching tab");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

    }

    protected void switchWindow() {
        log.info("Switching winows");
        String title;
        String winHandleBefore = driver.getWindowHandle();
        Set<String> all = driver.getWindowHandles();
        System.out.println(all.size());
        for(String winHandle : all)
        {   if(!winHandle.equals(winHandleBefore))
            driver.switchTo().window(winHandle);
        }

    }

    protected void closePresentTab()
    {
        driver.close();
    }


    protected void jsClick(String type, String locator)
    {
        WebElement element= driver.findElement(this.findElementByType(type,locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected String getCSSValues(String type, String locator, String property)
    {   WebElement element= driver.findElement(this.findElementByType(type,locator));
        return element.getCssValue(property);
    }

    protected String getAttributeProperty(String type, String locator, String attribute)
    {   WebElement element= driver.findElement(this.findElementByType(type,locator));
        return element.getAttribute(attribute);
    }

    protected String getAttributeProperty(WebElement element,String attribute)
    {
        return element.getAttribute(attribute);
    }

    protected void assertText(String type,String locator, String expectedText) {
        log.info("Asserting Text");
        String actualText=text(type,locator).trim();
        Assert.assertEquals(expectedText,actualText,"Expected string "+expectedText+"does not match actual string "+actualText );
    }

    protected void simpleAssertEquals(String actualText, String expectedText) {
        log.info("Asserting Equlas");
        Assert.assertEquals(expectedText,actualText,"Expected string "+expectedText+"does not match actual string "+actualText );
    }

    protected void simpleAssertEquals(int actualText, int expectedText) {
        log.info("Asserting Equlas");
        Assert.assertEquals(expectedText,actualText,"Expected string "+expectedText+"does not match actual string "+actualText );
    }

    protected void assertCSSProperty(String type,String locator,String property,String expectedText) {
        log.info("Asserting css property");
        String actualText=getCSSValues(type,locator,property);
        log.info("Css property "+property+" is: "+actualText);
        Assert.assertEquals(expectedText,actualText,"Expected string "+expectedText+"does not match actual string "+actualText );
    }

    protected void assertAttributePorperty(String type,String locator,String property,String expectedText) {
        log.info("Asserting css property");
        String actualText=getAttributeProperty(type,locator,property);
        Assert.assertEquals(expectedText,actualText,"Expected string "+expectedText+"does not match actual string "+actualText );
    }

    protected void waitByPolling(Function f)
    {

        Wait wait = new FluentWait(this.driver)
                .withTimeout(300, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.SECONDS)
                .ignoring(Exception.class);
        WebElement foo= (WebElement) wait.until((com.google.common.base.Function) f);
    }


}
