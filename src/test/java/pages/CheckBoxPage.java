package pages;

import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Log;

import java.util.ArrayList;
import java.util.HashSet;

public class CheckBoxPage extends Services {
    private Log logger= new Log();
    private String xpathToggleButton ="//*[@id=\"tree-node\"]//button[@aria-label='Toggle']";
    private String xpathBoxList ="//*[@id=\"tree-node\"]//ol/li";
    private String xpathButtonExpand ="//*[@id=\"tree-node\"]//button[@aria-label='Expand all']";
    private String xpathButtonCollapse ="//*[@id=\"tree-node\"]//button[@aria-label='Collapse all']";
    private String xpathBoxCheckBox="//*[@id='tree-node']//*[text()='%s']//preceding-sibling::span[@class='rct-checkbox']";
    private String xpathBoxCheckBoxChecked="//*[@class='rct-icon rct-icon-check']";
    private String xpathBoxCheckBoxUnChecked="//*[@class='rct-icon rct-icon-uncheck']";
    private String xpathBoxSucessText="//*[@id=\"result\"]/*[text()='%s']";
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    private String makeXpathForCheckBoxItem(String text){
        return String.format(xpathBoxCheckBox,text);
    }

    private String makeXpathForResultText(String text){
        return String.format(xpathBoxSucessText,text);
    }


    private String makeXpathForCheckBoxCheckedItem(String text){
        String path= String.format(xpathBoxCheckBox,text);
        return path+xpathBoxCheckBoxChecked;
    }

    private String makeXpathForCheckBoxUnCheckedItem(String text){
        String path= String.format(xpathBoxCheckBox,text);
        return path+xpathBoxCheckBoxUnChecked;
    }



    @Step("Verify if expected number {0} list are displayed")
    public CheckBoxPage verifyAllListItemDisplayed( int number)
    {   logger.info("Verify if all list are displayed");
        ArrayList<WebElement> list= (ArrayList<WebElement>) waitForElementsVisible("xpath",xpathBoxList);
        simpleAssertEquals(list.size(),number);
        return this;
    }

    @Step("Click on expand")
    public CheckBoxPage clickExpand() throws InterruptedException {
        logger.info("Click on expand");
        jsClick("xpath",xpathButtonExpand);
        Thread.sleep(3000);
        return this;
    }

    @Step("Click on Collapse")
    public CheckBoxPage clickCollapse()
    {
        logger.info("Click on Collapse");
        click("xpath",xpathButtonCollapse);
        return this;
    }

    @Step("Click on Check box {0}")
    public CheckBoxPage clickCheckBox(String text) throws InterruptedException {
        logger.info("Click on check box "+ text);
        String xpath=this.makeXpathForCheckBoxItem(text);
        scrollElementIntoView("xpath",xpath);
        click("xpath",xpath);
        return this;
    }

    @Step("Get value Check box {0} is checked")
    public boolean getCheckBoxSelected(String text)  {
        logger.info("Get check box check value for "+ text);
        try {
            WebElement element = waitForElement("xpath", this.makeXpathForCheckBoxCheckedItem(text));
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }

    @Step("Check if {0} is unchecked")
    public boolean getCheckBoxUnChecked(String text)  {
        logger.info("Check if "+ text+" is unchecked");
        try {
            WebElement element = waitForElement("xpath", this.makeXpathForCheckBoxUnCheckedItem(text));
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }

    @Step("Get value Check box {0} is checked")
    public boolean checkBoxResult(String text)  {
        logger.info("Get check box check value for "+ text);
        try {
            WebElement element = waitForElement("xpath", this.makeXpathForResultText(text));
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }

    @Step("Click on Check box Home")
    public CheckBoxPage verifyHomeClick( ) throws InterruptedException {
        HashSet<String> labels=labelTexts("Home");
        boolean flag=true;
        String value="";
        for(String text: labels)
        {
            if(!getCheckBoxSelected(text))
                flag=false;
                value=text;
                break;
        }
        String message="Value not found "+ value;
        simpleAssertTrue(flag,message);
        return this;
    }

    @Step("Verify Verify label {0} is not present in result")
    public CheckBoxPage verifyCheckButtonTextNotPresent(String label) throws InterruptedException {
        logger.info("Verify label "+ label +" is not present in result");
        HashSet<String> labels=resultTexts(label);
        boolean flag=true;
        String value="";
        for(String text: labels)
        {
            if(checkBoxResult(text)) {
                flag = false;
                value = text;
                break;
            }
        }
        String message="Value found "+ value;
        simpleAssertTrue(flag,message);
        return this;
    }


    @Step("Verify Verify label {0} is present in check")
    public CheckBoxPage verifyCheckButtonTextResults(String label) throws InterruptedException {
        logger.info("Verify label "+ label +" is present in result");
        HashSet<String> labels=resultTexts(label);
        boolean flag=true;
        String value="";
        for(String text: labels)
        {
            if(!checkBoxResult(text)) {
                flag = false;
                value = text;
                break;
            }
        }
        String message="Value not found "+ value;
        simpleAssertTrue(flag,message);
        return this;
    }


    @Step("Verify check box {0} is checked")
    public CheckBoxPage verifyCheckButton(String label) throws InterruptedException {
        logger.info("Get check box is checked for "+ label);
        HashSet<String> labels=labelTexts(label);
        boolean flag=true;
        String value="";
        for(String text: labels)
        {
            if(!getCheckBoxSelected(text)) {
                flag = false;
                value = text;
                break;
            }
        }
        String message="Value not found "+ value;
        simpleAssertTrue(flag,message);
        return this;
    }

    @Step("Verify check box {0} is unchecked")
    public CheckBoxPage verifyUnCheckButton(String label) throws InterruptedException {
        logger.info("Get check box is checked for "+ label);
        HashSet<String> labels=labelTexts(label);
        boolean flag=true;
        String value="";
        for(String text: labels)
        {
            if(!getCheckBoxUnChecked(text)) {
                flag = false;
                value = text;
                break;
            }
        }
        String message="Value not found "+ value;
        simpleAssertTrue(flag,message);
        return this;
    }


    public HashSet<String> labelTexts(String text)
    {
        HashSet<String> labels=new HashSet<String>();
        if(text.equalsIgnoreCase("Home"))
        {
            labels.add("Home");
            labels.add("Desktop");
            labels.add("Documents");
            labels.add("Downloads");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Desktop"))
        {
            labels.add("Desktop");
            labels.add("Notes");
            labels.add("Commands");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Documents") )
        {
            labels.add("Documents");
            labels.add("WorkSpace");
            labels.add("Office");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Documents") || text.equalsIgnoreCase("WorkSpace") )
        {
            labels.add("WorkSpace");
            labels.add("React");
            labels.add("Angular");
            labels.add("Veu");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Documents") || text.equalsIgnoreCase("Office") )
        {
            labels.add("Office");
            labels.add("Public");
            labels.add("Private");
            labels.add("Classified");
            labels.add("General");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Downloads") )
        {
            labels.add("Downloads");
            labels.add("Word File.doc");
            labels.add("Excel File.doc");
        }
        if(text.equalsIgnoreCase("vue") )
        {
            labels.add("vue");
        }
      return labels;

    }


    public HashSet<String> resultTexts(String text)
    {
        HashSet<String> labels=new HashSet<String>();
        if(text.equalsIgnoreCase("Home"))
        {
            labels.add("home");
            labels.add("desktop");
            labels.add("documents");
            labels.add("downloads");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Desktop"))
        {
            labels.add("desktop");
            labels.add("notes");
            labels.add("commands");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Documents") )
        {
            labels.add("documents");
            labels.add("workspace");
            labels.add("office");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Documents") || text.equalsIgnoreCase("WorkSpace") )
        {
            labels.add("workspace");
            labels.add("react");
            labels.add("angular");
            labels.add("veu");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Documents") || text.equalsIgnoreCase("Office") )
        {
            labels.add("office");
            labels.add("public");
            labels.add("private");
            labels.add("classified");
            labels.add("general");
        }
        if(text.equalsIgnoreCase("Home") || text.equalsIgnoreCase("Downloads") )
        {
            labels.add("downloads");
            labels.add("wordFile");
            labels.add("excelFile");
        }
        if(text.equalsIgnoreCase("vue") )
        {
            labels.add("vue");
        }
        return labels;

    }




}
