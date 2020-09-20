package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import utils.Log;

public class BrowserPage  extends Services {

    private Log logger= new Log();
    private String xpathTabButton ="//*[@id=\"tabButton\"]";
    private String xpathNewTabHeading="//*[@id='sampleHeading']";
    private String xpathWindowsButton="//*[@id=\"windowButton\"]";
    private String xpathWindowsMessageButton="//*[@id=\"messageWindowButton\"]";
    private String xpathWindowsMessage="/html/body";


    public BrowserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Tab Buttton")
    public BrowserPage clickTabButton(){
        logger.info("Click on  widgets card ");
        click("xpath",xpathTabButton);
        return this;
    }

    @Step("Verify Tab heading")
    public BrowserPage verifyTabText() throws InterruptedException, FindFailed {
        logger.info("Verify Tab heading");
        switchTab();
        s.swait("newTabMessage.PNG");
        s.findImageSimilar("newTabMessage.PNG",0.7);
        return this;
    }

    @Step("Click on Windows Button")
    public BrowserPage clickWindowButton(){
        logger.info("Click on  widgets card ");
        click("xpath",xpathWindowsButton);
        return this;
    }

    @Step("Switch Window")
    public BrowserPage switchToNewWindow(){
        logger.info("Verify new window text");
        switchWindow();
        return this;
    }


    @Step("Verify new window text")
    public BrowserPage verifyNewWindowMessage(){
        logger.info("Verify new window text");
        assertText("xpath",xpathNewTabHeading,"This is a sample page");
        return this;
    }

    @Step("Click on Windows Button")
    public BrowserPage clickWindowMessageButton(){
        logger.info("Click on  widgets card ");
        click("xpath",xpathWindowsMessageButton);
        return this;
    }

    @Step("Verify new window text")
    public BrowserPage verifyWindowMessage() throws FindFailed {
        logger.info("Verify new window");
        s.findImageSimilar("windowsPopUp.PNG",0.7);
        return this;
    }

    @Step("Verify new window text")
    public BrowserPage closeWindowMessage() throws FindFailed {
        logger.info("Verify new window");
        s.findImage("close.PNG");
        s.clickButton("close.PNG");
        return this;
    }





}
