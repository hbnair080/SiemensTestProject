package tests;

import org.testng.annotations.Test;

public class FramesPageTest extends BaseTest {


    public void verifyParentFrameText() throws InterruptedException {
        homepage
                .clickOnAlertsCard()
                .clickOnNestedFrametMenu()
                .switchToFrameOne()
                .verifyFrameText("Parent frame");
    }

    @Test
    public void verifyChildFrameText() throws InterruptedException {
        homepage
                .clickOnAlertsCard()
                .clickOnNestedFrametMenu()
                .switchToFrameOne()
                .switchToFrameTwo()
                .verifyFrameText("Child Iframe");
    }
}
