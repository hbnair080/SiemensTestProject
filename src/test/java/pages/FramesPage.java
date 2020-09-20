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
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify heading in Nested Frames page")
    public FramesPage verifyNestedFramesHeading()
    {   logger.info("Verify heading in Nested Frames page");
        assertText("xpath",xpattFramesPageHeader,"Nested Frames");
        return this;
    }

    @Step("Verify heading in Nested Frames page")
    public FramesPage switchToFrameOne()
    {
        switchFrames("xpath",xpathFrame1);
        return this;
    }

    @Step("Verify heading in Nested Frames page")
    public FramesPage verifyFrameText()
    {
        assertText("xpath",xpathFrameText,"Parent frame");
        return this;
    }








}
