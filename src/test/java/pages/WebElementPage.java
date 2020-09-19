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
    private String xpathTableValueBase="//*[@id='app']//div[@class='rt-tr-group']//div";
    private String xpathTableHeadingBase ="//*[@id='app']//div[@class='rt-tr']//div[text()='First Name']";

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
        assertElementVisible("xpath",path,true);
        return this;
    }

    @Step("Enter text to {0}")
    public WebElementPage SetValueTextArea(String label,String data)
    {   String path=xpathTextAreasBase+"[@placeholder='"+label+"']";
        typeData("xpath",path,data);
        return this;
    }

    @Step("Submit form")
    public WebElementPage submitForm()
    {   click("xpath",xpathSubmitButton);
        return this;
    }

    @Step("Verify value {0} is present")
    public WebElementPage verifyTableValuePresent(String data)
    {   String path=xpathTableValueBase+"[text()='"+data+"']";
        assertElementVisible("xpath",path,true);
        return this;
    }










}
