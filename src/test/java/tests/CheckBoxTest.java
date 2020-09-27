package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest
{

    @Test
    public void verifyExpand() throws InterruptedException {
        homepage
                .clickOnElementCard()
                .clickOnCheckBoxMenu()
                .clickExpand()
                .verifyAllListItemDisplayed(17);

    }

    @Test
    public void verifyCollapse() throws InterruptedException {
        homepage
                .clickOnElementCard()
                .clickOnCheckBoxMenu()
                .clickExpand()
                .verifyAllListItemDisplayed(17)
                .clickCollapse()
                .verifyAllListItemDisplayed(1);

    }


    @Test
    public void verifyHomeClick() throws InterruptedException {
        homepage
                .clickOnElementCard()
                .clickOnCheckBoxMenu()
                .clickCheckBox("Home")
                .clickExpand()
                .verifyHomeClick();

    }

    @Test(dataProvider = "labels")
    public void verifyClick(String label) throws InterruptedException {
        homepage
                .clickOnElementCard()
                .clickOnCheckBoxMenu()
                .clickExpand()
                .clickCheckBox(label)
                .verifyCheckButton(label)
                .verifyCheckButtonTextResults(label);

    }

    @Test(dataProvider = "labels")
    public void verifyUnChecked(String label) throws InterruptedException {
        homepage
                .clickOnElementCard()
                .clickOnCheckBoxMenu()
                .clickExpand()
                .clickCheckBox(label)
                .verifyCheckButton(label)
                .clickCheckBox(label)
                .verifyUnCheckButton(label)
                .verifyCheckButtonTextNotPresent(label);


    }


    @DataProvider
    public static Object[][] labels() {
        return new Object[][]{{"Home"},{"Veu"},{"Documents"},{"WorkSpace"},{"Desktop"}};
    }


}
