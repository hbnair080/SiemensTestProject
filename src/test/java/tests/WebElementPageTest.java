package tests;

import org.testng.annotations.DataProvider;
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
                .verifyAddFormLabelsEmail()
                .verifyTextArea("Email")
                .verifyAddFormLabelsAge()
                .verifyTextArea("Age")
                .verifyAddFormLabelsSalary()
                .verifyTextArea("Salary")
                .verifyAddFormLabelsDepartment()
                .verifyTextArea("Department");
    }

    @Test(dataProvider = "validForm")
    public void verifyValidFormSubmit(String firstName,String lastName, String emailID, String age, String salary, String dept ) {
        elementspage
                .clickOnWebElementMenu()
                .verifyAddButtonPresent()
                .clickAdd()
                .SetValueTextArea("First Name",firstName)
                .SetValueTextArea("Last Name",lastName)
                .SetValueTextArea("name@example.com",emailID)
                .SetValueTextArea("Age",age)
                .SetValueTextArea("Salary",salary)
                .SetValueTextArea("Department",dept)
                .submitForm();

    }


    @Test(dataProvider = "validForm")
    public void verifyDataAfterSubmit(String firstName,String lastName, String emailID, String age, String salary, String dept ) {
        elementspage
                .clickOnWebElementMenu()
                .verifyAddButtonPresent()
                .clickAdd()
                .SetValueTextArea("First Name",firstName)
                .SetValueTextArea("Last Name",lastName)
                .SetValueTextArea("name@example.com",emailID)
                .SetValueTextArea("Age",age)
                .SetValueTextArea("Salary",salary)
                .SetValueTextArea("Department",dept)
                .submitForm()
                .verifyTableValuePresent(firstName)
                .verifyTableValuePresent(lastName)
                .verifyTableValuePresent(emailID)
                .verifyTableValuePresent(age)
                .verifyTableValuePresent(salary)
                .verifyTableValuePresent(dept);

    }

    @DataProvider
    public static Object[][] validForm() {
        return new Object[][]{{"Hrishikesh", "B","hbnair080@gmail.com","27","200000","CSE"},{"Heera", "B","heera@gmail.com","22","200000","Engneering"}};
    }



}
