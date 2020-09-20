package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

import static org.testng.Assert.assertEquals;

public class ProgressBarPage extends Services {
    private Log logger= new Log();
    private String xpathProgressBarHeader="//*[@id='app']//div[@class='main-header']";
    private String xpathProgressBarScale="//*[@id='progressBar']/div[@role='progressbar']";
    private String xpathProgressBar="//*[@id='progressBar']";
    private String xpathStartStopButton="//*[@id=\"startStopButton\"]";
    private String xpathResetButton="//*[@id=\"resetButton\"]";
    private String xpathProgressBarLabel="//*[@id='progressBarContainer']/div[text()='Progress Bar']";



    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify heading in Progress bar page")
    public ProgressBarPage verifyProgressBarHeading()
    {   logger.info("Verify heading in Progress bar page");
        assertText("xpath",xpathProgressBarHeader,"Progress Bar");
        return this;
    }

    @Step("Verify in Progress bar present")
    public ProgressBarPage verifyProgressBarPresent()
    {   logger.info("Verify in Progress bar present");
        assertElementVisible("xpath",xpathProgressBar,true);
        return this;
    }

    @Step("Verify in Progress bar present")
    public ProgressBarPage verifyProgressBarScaleState()
    {   logger.info("Verify in Progress bar present");
        waitForElementVisible("xpath",xpathProgressBarScale);
        assertElementVisible("xpath",xpathProgressBarScale,true);
        return this;
    }

    @Step("Verify in Progress bar present")
    public ProgressBarPage verifyProgressBarScaleInvisible()
    {   logger.info("Verify in Progress bar present");
        waitForElementInVisible("xpath",xpathProgressBarScale);
        assertElementVisible("xpath",xpathProgressBarScale,false);
        return this;
    }

    @Step("Verify in Progress bar label present")
    public ProgressBarPage verifyProgressBarLabelPresent()
    {   logger.info("Verify in Progress bar label present");
        assertElementVisible("xpath",xpathProgressBarLabel,true);
        return this;
    }


    @Step("Verify Start Stop button Text")
    public ProgressBarPage verifyStartStopButtonTextPresent(String text)
    {   logger.info("Verify Start Stop button Text");
        assertText("xpath",xpathStartStopButton,text);
        return this;
    }

    @Step("Click Start Stop button Text")
    public ProgressBarPage clickOnStartStop()
    {   logger.info("Click Start Stop button Text");
        jsClick("xpath",xpathStartStopButton);
        return this;
    }

    @Step("Verify Text of Start and Stop button")
    public  ProgressBarPage verifyStartStopText(String text)
    {   logger.info("Verify Text of Start and Stop button");
        assertText("xpath",xpathStartStopButton,text);
        return this;
    }

    @Step("Wait Till value is success")
    public  ProgressBarPage waitProgressBar() throws InterruptedException {
        boolean value=false;
        String propertyValue;
        int count=0;
        logger.info("Verify till Progress bar become successful ");
        while(!value)
        {   ++count;
            propertyValue=getAttributeProperty("xpath",xpathProgressBarScale,"class");
            logger.info("Wait till Progress bar become successful");
            logger.info("Property class value is: "+propertyValue);
            if(propertyValue.equals("progress-bar bg-success"))
            {
                value=true;
            }
            if(count==20)
            {
                break;
            }
            Thread.sleep(5000);
        }
        return this;
    }

    @Step("Verify background color change")
    public  ProgressBarPage verifyBackground(String color)
    {   logger.info("Verify background color change");
        assertCSSProperty("xpath",xpathProgressBarScale,"background-color",color);
        return this;

    }

    @Step("Verify in Reset button present")
    public  ProgressBarPage verifyResetButton()
    {   logger.info("Verify in Reset  button present");
        assertElementVisible("xpath",xpathProgressBarLabel,true);
        return this;

    }

    @Step("Verify in Reset button present")
    public  ProgressBarPage clickOnResetButton()
    {   logger.info("Click on Reset button");
        click("xpath",xpathResetButton);
        return this;

    }


    @Step("Verify in Reset button present")
    public  ProgressBarPage verifyMiddleStateProgressBar()
    {   logger.info("Click on Reset button");
        click("xpath",xpathResetButton);
        return this;

    }

    public ProgressBarPage waitForProgressBarMiddle() throws InterruptedException {
        //waitForAttributeContains("xpath",xpathProgressBarScale,"aria-valuenow","48");
        Thread.sleep(300);
        return this;
    }

    public ProgressBarPage verifyProgressBarTextAt100()
    {
        assertText("xpath",xpathProgressBarScale,"100");
        return this;
    }

    public ProgressBarPage verifyProgressBarText()
    {
        String textValue=text("xpath",xpathProgressBarScale);
        String PropertyValue=getAttributeProperty("xpath",xpathProgressBarScale,"aria-valuenow");
        PropertyValue=PropertyValue+"%";
        simpleAssertEquals(textValue,PropertyValue);
        return this;
    }

}
