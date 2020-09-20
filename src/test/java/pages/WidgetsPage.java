package pages;

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
}
