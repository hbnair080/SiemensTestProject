package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class FramesPage extends Services {
    private Log logger= new Log();
    private String xpattFramesPageHeader="//*[@id='app']//div[@class='main-header']";
    private String xpathFrame1 ="//*[@id=\"frame1\"]";
    private String xpathFrameText="//body";
    private String xpathFrame2="//iframe[contains(@srcdoc,'Child Iframe')]";

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify heading in Nested Frames page")
    public FramesPage verifyNestedFramesHeading()
    {   logger.info("Verify heading in Nested Frames page");
        assertText("xpath",xpattFramesPageHeader,"Nested Frames");
        return this;
    }

    @Step("Switch to Frame 1")
    public FramesPage switchToFrameOne()
    {   logger.info("Switch to Frame 1");
        switchFrames("xpath",xpathFrame1);
        return this;
    }

    @Step("Switch to Frame 2")
    public FramesPage switchToFrameTwo()
    {   logger.info("Switch to Frame 2");
        switchFrames("xpath",xpathFrame2);
        return this;
    }

    @Step("Verify heading in Nested Frames page")
    public FramesPage verifyFrameText(String text)
    {   logger.info("Verify text");
        assertText("xpath",xpathFrameText,text);
        return this;
    }

    @Step("Switch to Main")
    public FramesPage switchMain(String text)
    {   logger.info("Switch to Main");
        switchMainContent();
        return this;
    }








}
