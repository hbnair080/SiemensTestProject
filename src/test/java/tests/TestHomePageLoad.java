package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class TestHomePageLoad extends BaseTest {

    @Test
    public void testHomePageLoad() {
        homepage
                .verifyHomePageLoad()
                .verifyElementLoad();
    }

}
