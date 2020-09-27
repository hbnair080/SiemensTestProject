package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class WidgetsPage extends Services {
    private Log logger= new Log();
    private String xpathProgressBarMenu ="//span[text()='Progress Bar']";
    private String xpathDatePickerMenu ="//span[text()='Date Picker']";

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on menu item")
    public ProgressBarPage clickOnProgressBarMenu(){
        logger.info("Scroll progress bar menu into view");
        scrollElementIntoView("xpath",xpathProgressBarMenu);
        logger.info("Click on menu item");
        jsClick("xpath",xpathProgressBarMenu);
        return new ProgressBarPage(driver);
    }

    @Step("Click on date picker menu item")
    public DatePickerPage clickOnDatePickerMenu(){
        logger.info("Scroll date picker menu into view");
        scrollElementIntoView("xpath",xpathDatePickerMenu);
        logger.info("Click on menu item");
        jsClick("xpath",xpathDatePickerMenu);
        return new DatePickerPage(driver);
    }

}
