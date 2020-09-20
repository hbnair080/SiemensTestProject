package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class AlertsPage extends Services {
    private Log logger= new Log();
    private String xpathSeeAlert ="//*[@id=\"alertButton\"]";
    private String xpathWaitAlert ="//*[@id=\"timerAlertButton\"]";
    private String xpathActionAlert ="//*[@id=\"confirmButton\"]";
    private String xpathActionText ="//*[@id=\"confirmResult\"]";
    private String xpathPromptAlert ="//*[@id=\"promtButton\"]";
    private String xpathPromptText ="//*[@id=\"promptResult\"]";


    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on See Alert Buttton")
    public AlertsPage clickSeeAlertButton(){
        logger.info("Click on  See Alert Button ");
        click("xpath",xpathSeeAlert);
        return this;
    }

    @Step("Click on Time Alert Buttton")
    public AlertsPage clickTimeAlertButton(){
        logger.info("Click on Time Alert Buttton ");
        click("xpath",xpathWaitAlert);
        return this;
    }

    @Step("Click on Action Alert Buttton")
    public AlertsPage clickActionAlertButton(){
        logger.info("Click on Action Alert Buttton ");
        click("xpath",xpathActionAlert);
        return this;
    }

    @Step("Click on Prompt Alert Buttton")
    public AlertsPage clickPromptAlertButton(){
        logger.info("Click on Action Alert Buttton ");
        click("xpath",xpathPromptAlert);
        return this;
    }

    @Step("Accept alert")
    public AlertsPage clickAlertOk(){
        logger.info("Accept Alert");
        waitForAlertAndAccept();
        return this;
    }

    @Step("Accept alert")
    public AlertsPage clickAlertDismiss(){
        logger.info("Accept Alert");
        waitForAlertAndDismiss();
        return this;
    }

    @Step("Verify alert text")
    public AlertsPage verifyAlertText(String expectedText){
        logger.info("Verify alert text");
        String text=alertText();
        simpleAssertEquals(text,expectedText);
        return this;
    }

    @Step("Verify alert text")
    public AlertsPage verifyActionText(String expectedText){
        logger.info("Verify alert text");
        assertText("xpath",xpathActionText,expectedText);
        return this;
    }

    @Step("Send data to alert")
    public AlertsPage sendTextToAlert(String text){
        logger.info("Send data to alert");
        alertSendKey(text);
        return this;
    }

    @Step("Verify prompt text")
    public AlertsPage verifyPromptText(String expectedText){
        logger.info("Verify prompt text");
        assertText("xpath",xpathPromptText,expectedText);
        return this;
    }







}
