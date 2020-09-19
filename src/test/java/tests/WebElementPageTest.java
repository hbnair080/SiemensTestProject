package tests;

import org.testng.annotations.Test;

public class WebElementPageTest extends BaseTest {


    public void testWebElementPageTitle()
    {
        elementspage
                .clickOnWebElementMenu()
                .verifyTitle();
    }

    public void verifyAddButton(){
        elementspage
                    .clickOnWebElementMenu()
                    .verifyAddButtonPresent()
                    .clickAdd()
                    .verifyAddPopUpdDisplayed();
    }


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
