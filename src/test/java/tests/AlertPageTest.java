package tests;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class AlertPageTest extends BaseTest {

    @Test
    public void verifySeeAlertButton(){
        homepage
                .clickOnAlertsCard()
                .clickOnAlertMenu()
                .clickSeeAlertButton()
                .verifyAlertText("You clicked a button")
                .clickAlertOk();
    }

    @Test
    public void verifyTimeAlertButton(){
        homepage
                .clickOnAlertsCard()
                .clickOnAlertMenu()
                .clickTimeAlertButton()
                .verifyAlertText("This alert appeared after 5 seconds")
                .clickAlertOk();
    }

    @Test
    public void verifyActionAlertButtonAndAccept(){
        homepage
                .clickOnAlertsCard()
                .clickOnAlertMenu()
                .clickActionAlertButton()
                .verifyAlertText("Do you confirm action?")
                .clickAlertOk()
                .verifyActionText("You selected Ok");
    }

    @Test
    public void verifyActionAlertButtonAndDismiss(){
        homepage
                .clickOnAlertsCard()
                .clickOnAlertMenu()
                .clickActionAlertButton()
                .verifyAlertText("Do you confirm action?")
                .clickAlertDismiss()
                .verifyActionText("You selected Cancel");
    }

    @Test
    public void verifyPromptAlertAndAccept(){
        homepage
                .clickOnAlertsCard()
                .clickOnAlertMenu()
                .clickPromptAlertButton()
                .verifyAlertText("Please enter your name")
                .sendTextToAlert("Hrishikesh")
                .clickAlertOk()
                .verifyPromptText("You entered Hrishikesh");
    }
}
