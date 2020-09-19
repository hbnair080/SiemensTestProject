package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class WebElementPage extends Services {
    private Log logger= new Log();

    private String xpathHeader="//*[@id='app']//div[text()='Web Tables']";
    private String xpathAddButton="//*[@id=\"addNewRecordButton\"]";
    private String xpathAddPopUp="//div[@class='modal-content']";
    private String xpathAddPopHeading="//*[@id=\"registration-form-modal\"]";
    private String xpathPopUpLabels="//div[@class='modal-content']//label";
    private String xpathTextAreasBase="//div[@class='modal-content']//input";
    private String xpathSubmitButton="//*[@id='submit']";

    public WebElementPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify header of web element page")
    public WebElementPage verifyTitle() {
        waitForElement("xpath",xpathHeader);
        logger.info("Home Page Loaded");
        return this;
    }

    @Step("Verify Add button is visible")
    public WebElementPage verifyAddButtonPresent()
    {
        assertElementVisible("xpath",xpathAddButton,true);
        return this;
    }

    @Step("Click on add")
    public WebElementPage clickAdd()
    {
        click("xpath",xpathAddButton);
        return this;
    }

    @Step("Verify pop up dispalyed")
    public WebElementPage verifyAddPopUpdDisplayed()
    {
        isElementPresent("xpath",xpathAddPopUp);
        return this;
    }

    @Step("Verify heading in pop up")
    public WebElementPage verifyAddPopUpHeading()
    {
        assertText("xpath",xpathAddPopHeading,"Registration Form");
        return this;
    }

    @Step("Verify First name Label")
    public WebElementPage verifyAddFormLabelsFirstName()
    {   String path=xpathPopUpLabels+"[text()='First Name']";
        assertElementVisible("xpath",path,true);
        return this;
    }

    @Step("Verify First name Label")
    public WebElementPage verifyAddFormLabelsLastName()
    {   String path=xpathPopUpLabels+"[text()='Last Name']";
        assertElementVisible("xpath",path,true);
        return this;
    }

    @Step("Verify Email Label")
    public WebElementPage verifyAddFormLabelsEmail()
    {   String path=xpathPopUpLabels+"[text()='Email']";
        assertElementVisible("xpath",path,true);
        return this;
    }

    @Step("Verify Age Label")
    public WebElementPage verifyAddFormLabelsAge()
    {   String path=xpathPopUpLabels+"[text()='Age']";
        assertElementVisible("xpath",path,true);
        return this;
    }

    @Step("Verify Salary Label")
    public WebElementPage verifyAddFormLabelsSalary()
    {   String path=xpathPopUpLabels+"[text()='Salary']";
        assertElementVisible("xpath",path,true);
        return this;
    }

    @Step("Verify Department Label")
    public WebElementPage verifyAddFormLabelsDepartment()
    {   String path=xpathPopUpLabels+"[text()='Salary']";
        assertElementVisible("xpath",path,true);
        return this;
    }

    @Step("Verify Department Label")
    public WebElementPage verifyAddSubmitButton()
    {
        assertElementVisible("xpath",xpathSubmitButton,true);
        return this;
    }

    @Step("Verify Text area for label {0}")
    public WebElementPage verifyTextArea(String label)
    {   String path=xpathTextAreasBase+"[@placeholder='"+label+"']";
        assertElementVisible("xpath",xpathSubmitButton,true);
        return this;
    }








}
