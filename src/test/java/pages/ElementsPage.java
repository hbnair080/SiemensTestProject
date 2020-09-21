package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class ElementsPage extends Services {

    private Log logger= new Log();
    private String xpathWebElementMenu ="//span[text()=\"Web Tables\"]";
    private String xpathUploadDownloadMenu ="//span[text()=\"Upload and Download\"]";
    private String xpathCheckBoxMenu ="//span[text()=\"Check Box\"]";

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on  WebElement menu item")
    public WebElementPage clickOnWebElementMenu(){
        logger.info("Click on  WebElement menu item");
        scrollElementIntoView("xpath",xpathWebElementMenu);
        click("xpath",xpathWebElementMenu);
        return new WebElementPage(driver);
    }

    @Step("Click on download menu item")
    public UploadDownloadPage clickOnUploadDownloadMenu() throws InterruptedException {
        logger.info("Click on download menu item");
        scrollElementIntoView("xpath",xpathUploadDownloadMenu);
        Thread.sleep(1000);
        click("xpath",xpathUploadDownloadMenu);
        return new UploadDownloadPage(driver);
    }

    @Step("Click on download menu item")
    public CheckBoxPage clickOnCheckBoxMenu() {
        logger.info("Click on Check Box menu item");
        scrollElementIntoView("xpath",xpathCheckBoxMenu);
        click("xpath",xpathCheckBoxMenu);
        return new CheckBoxPage(driver);
    }


}
