package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class WidgetsPage extends Services {
    private Log logger= new Log();
    private String xpathProgressBarMenu ="//span[text()='Progress Bar']";

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public WebElementPage clickOnProgressBarMenu(){
        scrollElementIntoView("xpath",xpathProgressBarMenu);
        click("xpath",xpathProgressBarMenu);
        return new WebElementPage(driver);
    }


    @Step("Verify heading in Progress bar page")
    public WidgetsPage verifyAddPopUpHeading()
    {   logger.info("Verify heading in Progress bar page");
        assertText("xpath",xpathProgressBarMenu,"Registration Form");
        return this;
    }
}
