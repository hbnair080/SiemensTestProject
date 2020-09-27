package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest  {

    @Test
    public void verifyDatePickerPage() {
        homepage
                .clickOnWidgetsCard()
                .clickOnDatePickerMenu()
                .verifySelectDateLabel()
                .clickSelectDate()
                .verifyDatePickerVisibilty();

    }

    @Test(dataProvider = "datePickerValues")
    public void verifySelectionOFDatePicker(String year,String month,String date) {
        homepage
                .clickOnWidgetsCard()
                .clickOnDatePickerMenu()
                .verifySelectDateLabel()
                .clickSelectDate()
                .verifyDatePickerVisibilty()
                .selectYearInDatePicker(year)
                .selectMonthInDatePicker(month)
                .selectDateInDatePicker(date)
                .verifyDateinDatePicker(year,date,month);

    }

    @Test
    public void verifyDateTimePickerPage() {
        homepage
                .clickOnWidgetsCard()
                .clickOnDatePickerMenu()
                .verifySelectDateTimeLabel()
                .clickSelectDateTime()
                .verifyDateTimePickerVisibilty();

    }

    @Test(dataProvider = "timePickerValues")
    public void verifySelectionOFDateTimePicker(String year,String month,String date,String time) {
        homepage
                .clickOnWidgetsCard()
                .clickOnDatePickerMenu()
                .verifySelectDateTimeLabel()
                .clickSelectDateTime()
                .verifyDateTimePickerVisibilty()
                .clickSelectDateTimeYear()
                .selectYearInDateTimePicker(year)
                .clickSelectDateTimeMonth()
                .selectMonthInDateTimePicker(month)
                .selectDateInDateTimePicker(date)
                .selectTimeInDateTimePicker(time)
                .verifyDateInDateTimePicker(year,date,month,time);

    }

    @DataProvider
    public static Object[][] datePickerValues() {
        return new Object[][]{{"2021","December","31"},{"2025","January","1"},{"2019","June","1"},{"2022","April","15"},{"2023","October","2"}};
    }

    @DataProvider
    public static Object[][] timePickerValues() {
        return new Object[][]{{"2021","December","21","00:00"},{"2025","January","10","12:30"},{"2019","June","15","3:45"},{"2022","April","15","21:30"},{"2023","October","9","23:00"}};
    }
}
