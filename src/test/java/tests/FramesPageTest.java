package tests;

import org.testng.annotations.Test;

public class FramesPageTest extends BaseTest {

    @Test
    public void verifyParenFrameText() throws InterruptedException {
        homepage
                .clickOnAlertsCard()
                .clickOnNestedFrametMenu()
                .switchToFrameOne()
                .verifyFrameText();
    }
}
