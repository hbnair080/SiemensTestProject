package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;

@Listeners({ TestListener.class })
public class WebElementPageTest extends BaseTest {

    @Test
    public void testWebElementPageTitle()
    {
        elementspage
                .clickOnWebElementMenu()
                .verifyTitle();
    }

    @Test
    public void verifyAddButton(){
        elementspage
                    .clickOnWebElementMenu()
                    .verifyAddButtonPresent()
                    .clickAdd()
                    .verifyAddPopUpdDisplayed();
    }

    @Test
    public void verifyPopUp(){
        elementspage
                .clickOnWebElementMenu()
                .verifyAddButtonPresent()
                .clickAdd()
                .verifyAddPopUpdDisplayed()
                .verifyAddPopUpHeading();
    }

    @Test
    public void verifyPopUpElements(){
        elementspage
                .clickOnWebElementMenu()
                .verifyAddButtonPresent()
                .clickAdd()
                .verifyAddPopUpdDisplayed()
                .verifyAddPopUpHeading()
                .verifyAddFormLabelsFirstName()
                .verifyTextArea("First Name")
                .verifyAddFormLabelsLastName()
                .verifyTextArea("Last Name")
                .verifyAddFormLabelsAge()
                .verifyTextArea("Age")
                .verifyAddFormLabelsSalary()
                .verifyTextArea("Salary")
                .verifyAddFormLabelsDepartment()
                .verifyTextArea("Department");
    }




}
