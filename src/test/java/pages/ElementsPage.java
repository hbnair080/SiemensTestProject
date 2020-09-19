package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class ElementsPage extends Services {

    private Log logger= new Log();
    private String xpathWebElementMenu ="//span[text()=\"Web Tables\"]";

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on  WebElement menu item")
    public WebElementPage clickOnWebElementMenu(){
        scrollElementIntoView("xpath",xpathWebElementMenu);
        click("xpath",xpathWebElementMenu);
        return new WebElementPage(driver);
    }
}
