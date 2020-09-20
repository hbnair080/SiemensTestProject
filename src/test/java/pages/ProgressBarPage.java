package pages;

import lib.Services;
import org.openqa.selenium.WebDriver;

public class ProgressBarPage extends Services {

    private String xpathProgressBarHeader="//*[@id='app']//div[@class='main-header']";

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }
}
