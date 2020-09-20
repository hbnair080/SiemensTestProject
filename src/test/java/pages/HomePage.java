package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.Log;
import lib.Services;

public class HomePage extends Services {

    private Log logger= new Log();
    private String xpathBannerHeaderImage ="//*[@id='app']/header//img";
    private String xpathBannerImage = "//*[@id='app']//div[@class='home-banner']//img";
    private String xpathHeaderLink ="//*[@id='app']/header//a";
    private String xpathBannerLink ="//*[@id='app']//div[@class='home-banner']//a";
    private String xpathCatogryCardParent ="//*[@id='app']//div[@class='category-cards']";
    private String xpathCatogryCardElement="//*[@id='app']//div[@class='category-cards']//div[@class='card mt-4 top-card'][1]";
    private String xpathCatogryCardWideget="//*[@id='app']//div[@class='category-cards']//div[@class='card mt-4 top-card'][4]";
    private String xpathCatogryCardAlerts="//*[@id='app']//div[@class='category-cards']//div[@class='card mt-4 top-card'][3]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify Home page is loaded")
    public HomePage verifyHomePageLoad() {
        waitForElement("xpath",xpathBannerHeaderImage);
        waitForElement("xpath",xpathBannerImage);
        logger.info("Home Page Loaded");
        return this;
    }

    @Step("Verify Element card is loaded")
    public HomePage verifyElementLoad() {
        waitForElement("xpath",xpathCatogryCardElement);
        logger.info("Verify Element card is loaded");
        return this;
    }

    @Step("Click on  element card")
    public ElementsPage clickOnElementCard(){
        scrollElementIntoView("xpath",xpathCatogryCardElement);
        logger.info("Click on  element card ");
        click("xpath",xpathCatogryCardElement);
        return new ElementsPage(this.driver);
    }

    @Step("Click on  widgets card")
    public WidgetsPage clickOnWidgetsCard(){
        scrollElementIntoView("xpath",xpathCatogryCardWideget);
        logger.info("Click on  widgets card ");
        click("xpath",xpathCatogryCardWideget);
        return new WidgetsPage(this.driver);
    }

    @Step("Click on  Alerts card")
    public AlertsWindowsFramesPage clickOnAlertsCard(){
        scrollElementIntoView("xpath",xpathCatogryCardAlerts);
        logger.info("Click on  Alerts card ");
        click("xpath",xpathCatogryCardAlerts);
        return new AlertsWindowsFramesPage(this.driver);
    }





}
