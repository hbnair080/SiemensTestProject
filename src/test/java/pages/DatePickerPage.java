package pages;
import io.qameta.allure.Step;
import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

import java.time.Month;

public class DatePickerPage extends Services {
    private Log logger= new Log();

    private String xpathSelectDateLabel="//*[text()='Select Date']";
    private String xpathDateAndTimeLabel="//*[text()='Date And Time']";
    private String xpathSelectDatePicker="//*[@id=\"datePickerMonthYear\"]/div";
    private String xpathSelectDateTimePicker="//input[@id='dateAndTimePickerInput']";
    private String xpathSelectDatePickerFrame="//*[@id='datePickerMonthYear']//div[@class='react-datepicker__month-container']";
    private String xpathSelectDateTimePickerFrame="//*[@id='dateAndTimePicker']//div[@class='react-datepicker-popper']";
    private String xpathMonthDropDown="//select[contains(@class,'month')]";
    private String xpathYearDropDown="//select[contains(@class,'year')]";
    private String xpathSelectDateInDatePicker="//div[contains(@class,'react-datepicker__day') and text()=%s]";
    private String xpathDateTextArea="//input[@id='datePickerMonthYearInput']";
    private String xpathDateTimeMonthClick ="//*[@id='dateAndTimePicker']//div[@class='react-datepicker__month-read-view']";
    private String xpathDateTimeYearClick ="//*[@id='dateAndTimePicker']//div[@class='react-datepicker__year-read-view']";
    private String xpathSelectMonthInDateTimePicker="//div[@class='react-datepicker__month-option'][text()='%s']";
    private String xpathSelectYearInDateTimePicker="//div[@class='react-datepicker__year-option'][text()='%s']";
    private String xpathSelectDateInDateTimePicker="//div[contains(@class,'react-datepicker__day')][text()='%s']";
    private String xpathSelectTimeInDateTimePicker="//li[contains(@class,'react-datepicker__time-list-item ')][text()='%s']";



    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    private String makeXpathDateinDatePicker(String text){
        return String.format(xpathSelectDateInDatePicker,text);
    }

    private String makeXpathMonthinDateTimePicker(String text){
        return String.format(xpathSelectMonthInDateTimePicker,text);
    }

    private String makeXpathYearinDateTimePicker(String text){
        return String.format(xpathSelectYearInDateTimePicker,text);
    }

    private String makeXpathDateinDateTimePicker(String text){
        return String.format(xpathSelectDateInDateTimePicker,text);
    }

    private String makeXpathTimeinDateTimePicker(String text){
        return String.format(xpathSelectTimeInDateTimePicker,text);
    }



    @Step("Verify header of Select date label page")
    public DatePickerPage verifySelectDateLabel() {
        logger.info("Verify header of Select date label page");
        assertElementVisible("xpath",xpathSelectDateLabel,true);
        return this;
    }

    @Step("Verify header of Select date time label page")
    public DatePickerPage verifySelectDateTimeLabel() {
        logger.info("Verify header of Select date time label page");
        assertElementVisible("xpath",xpathDateAndTimeLabel,true);
        return this;
    }


    @Step("Click Select date text area")
    public DatePickerPage clickSelectDate() {
        logger.info("Click Select date text area");
        click("xpath",xpathSelectDatePicker);
        return this;
    }

    @Step("Click Select date time text area")
    public DatePickerPage clickSelectDateTime() {
        logger.info("Click Select date time text area");
        jsClick("xpath",xpathSelectDateTimePicker);
        return this;
    }

    @Step("Click date time month area")
    public DatePickerPage clickSelectDateTimeMonth(){
        logger.info("Click Select date time text area");
        click("xpath",xpathDateTimeMonthClick);
        return this;
    }

    @Step("Click date time year area")
    public DatePickerPage clickSelectDateTimeYear(){
        logger.info("Click Select date time text area");
        jsClick("xpath",xpathDateTimeYearClick);
        return this;
    }

    @Step("Select date time Month")
    public DatePickerPage selectDateTimeMonth(){
        logger.info("Select date time Months");
        click("xpath",xpathDateTimeYearClick);
        return this;
    }


    @Step("Verify Date Picker is visble")
    public DatePickerPage verifyDatePickerVisibilty() {
        logger.info("Verify Date Picker is visble");
        assertElementVisible("xpath",xpathSelectDatePickerFrame,true);
        return this;
    }

    @Step("Verify Date Time Picker is visble")
    public DatePickerPage verifyDateTimePickerVisibilty() {
        logger.info("Verify Date Time Picker is visble");
        assertElementVisible("xpath",xpathSelectDateTimePickerFrame,true);
        return this;
    }


    @Step("Select month {0}")
    public DatePickerPage selectMonthInDatePicker(String month)
    {
        logger.info("Select month "+month);
        selectByVisibleText("xpath",xpathMonthDropDown,month);
        return this;
    }

    @Step("Select month {0}")
    public DatePickerPage selectMonthInDateTimePicker(String month) {
        logger.info("Select month "+month);
        String xpath=makeXpathMonthinDateTimePicker(month);
        jsClick("xpath",xpath);
        return this;
    }

    @Step("Select year {0}")
    public DatePickerPage selectYearInDateTimePicker(String year) {
        logger.info("Select year "+year);
        String xpath=makeXpathYearinDateTimePicker(year);
        scrollElementIntoView("xpath",xpath);
        jsClick("xpath",xpath);
        return this;
    }

    @Step("Select year {0}")
    public DatePickerPage selectYearInDatePicker(String year) {
        logger.info("Select year "+year);
        selectByVisibleText("xpath",xpathYearDropDown,year);
        return this;
    }

    @Step("Select date {0}")
    public DatePickerPage selectDateInDatePicker(String date)
    {
        logger.info("Select date "+date);
       String path= makeXpathDateinDatePicker(date);
       jsClick("xpath",path);
       return this;
    }

    @Step("Select date {0}")
    public DatePickerPage selectDateInDateTimePicker(String date){
        logger.info("Select date "+date);
        String path= makeXpathDateinDateTimePicker(date);
        scrollElementIntoView("xpath",path);
        jsClick("xpath",path);
        return this;
    }

    @Step("Select time {0}")
    public DatePickerPage selectTimeInDateTimePicker(String time) {
        logger.info("Select time "+time);
        String path= makeXpathTimeinDateTimePicker(time);
        scrollElementIntoView("xpath",path);
        jsClick("xpath",path);
        return this;
    }

    @Step("Verify Date in date picker")
    public DatePickerPage verifyDateinDatePicker(String year,String date,String month)
    {
        String expectedValue=getDateInFormat(year,date,month);
        scrollElementIntoView("xpath",xpathDateTextArea);
        String actualValue=getAttributeProperty("xpath",xpathDateTextArea,"value");
        simpleAssertEquals(expectedValue,actualValue);
        return this;
    }

    @Step("Verify Date in date time picker")
    public DatePickerPage verifyDateInDateTimePicker(String year,String date,String month, String time)
    {
        String expectedValue=getDateTimefroamt(year,date,month,time);
        String actualValue=getAttributeProperty("xpath",xpathSelectDateTimePicker,"value");
        simpleAssertEquals(expectedValue,actualValue);
        return this;
    }

    public String getDateTimefroamt(String year,String date,String month,String time)
    {
        String [] list=time.split(":");
        int new_time= ((Integer.parseInt(list[0]) + 11) % 12 + 1);
        if(Integer.parseInt(list[0])<12)
            time=new_time+":"+list[1]+" AM";
        else
            time=new_time+":"+list[1]+" PM";
        return month+" "+date+", "+year+" "+time;
    }

    public String getDateInFormat(String year,String date,String month)
    {
        String monthString;
        switch (month) {
            case "January":  monthString ="01" ;       break;
            case "February":  monthString = "02";         break;
            case "March":  monthString = "03";         break;
            case "April":  monthString = "04";         break;
            case "May":  monthString = "05";           break;
            case "June":  monthString = "06";          break;
            case "July":  monthString = "07";          break;
            case "August":  monthString = "08";        break;
            case "September":  monthString = "09";     break;
            case "October": monthString = "10";       break;
            case "November": monthString = "11";      break;
            case "December": monthString = "12";      break;
            default: monthString = "Invalid month"; break;
        }
        if(Integer.parseInt(date)<10)
            date="0"+date;
        System.out.println(monthString);
        return monthString+"/"+date+"/"+year;
    }
}
