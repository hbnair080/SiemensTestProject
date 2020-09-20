package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class AlertsWindowsFramesPage extends Services {

    private Log logger= new Log();
    private String xpathFramesMenu ="//span[text()=\"Nested Frames\"]";
    private String xpathBrowserdMenu ="//span[text()=\"Browser Windows\"]";

    public AlertsWindowsFramesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on  Frames menu item")
    public FramesPage clickOnNestedFrametMenu(){
        logger.info("Click on  WebElement menu item");
        scrollElementIntoView("xpath",xpathFramesMenu);
        click("xpath",xpathFramesMenu);
        return new FramesPage(driver);
    }

    @Step("Click on Browser menu item")
    public BrowserPage clickOnBrowserMenu() throws InterruptedException {
        logger.info("Click on download menu item");
        scrollElementIntoView("xpath",xpathBrowserdMenu);
        Thread.sleep(1000);
        click("xpath",xpathBrowserdMenu);
        return new BrowserPage(driver);
    }
}
