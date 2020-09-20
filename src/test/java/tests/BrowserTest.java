package tests;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class BrowserTest extends BaseTest {
    @Test
    public void verifyTabButton() throws InterruptedException, FindFailed {
        homepage
                .clickOnAlertsCard()
                .clickOnBrowserMenu()
                .clickTabButton()
                .verifyTabText();
    }

    @Test
    public void verifyWindowButton() throws InterruptedException {
        homepage
                .clickOnAlertsCard()
                .clickOnBrowserMenu()
                .clickWindowButton()
                .switchToNewWindow()
                .verifyNewWindowMessage();
    }

    @Test
    public void verifyMessageWindowButton() throws InterruptedException, FindFailed {
        homepage
                .clickOnAlertsCard()
                .clickOnBrowserMenu()
                .clickWindowMessageButton()
                .verifyWindowMessage()
                .closeWindowMessage();
    }


}
