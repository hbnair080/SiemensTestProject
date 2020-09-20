package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class ElementsPage extends Services {

    private Log logger= new Log();
    private String xpathWebElementMenu ="//span[text()=\"Web Tables\"]";
    private String xpathUploadDownloadMenu ="//span[text()=\"Upload and Download\"]";

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on  WebElement menu item")
    public WebElementPage clickOnWebElementMenu(){
        scrollElementIntoView("xpath",xpathWebElementMenu);
        click("xpath",xpathWebElementMenu);
        return new WebElementPage(driver);
    }

    public UploadDownloadPage clickOnUploadDownloadMenu() throws InterruptedException {
        scrollElementIntoView("xpath",xpathUploadDownloadMenu);
        Thread.sleep(1000);
        click("xpath",xpathUploadDownloadMenu);
        return new UploadDownloadPage(driver);
    }


}
