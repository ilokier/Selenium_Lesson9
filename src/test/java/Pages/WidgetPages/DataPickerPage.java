package Pages.WidgetPages;

import Heplers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DataPickerPage {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    WaitHelper wait = new WaitHelper();
    @FindBy(id = "datepicker")
    WebElement dataPickerInput;
    @FindBy(css = ".ui-datepicker-today")
    WebElement todayDate;
    @FindBy(css = ".ui-datepicker-next")
    WebElement nextMontharrow;
    @FindBy(css = ".ui-datepicker-prev")
    WebElement prevMontharrow;
    @FindBy(css = ".ui-datepicker-month")
    WebElement actualVisibleMonth;
    @FindBy(css = ".ui-datepicker-year")
    WebElement actualVisibleYear;
    @FindBy(css = "#ui-datepicker-div > table > tbody > tr:nth-child(3) > td:nth-child(6) > a")
    WebElement chosenDay;

    @FindBy(css = "td:not(.ui-datepicker-other-month) .ui-state-default")
    List<WebElement> defaultDaysOfCurrentMonth;

//    public int getTodayYear() {
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        log.info("Year is: " + year);
//        return year;
//    }
//
//    public int getTodayMonth() {
//        int month = Calendar.getInstance().get(Calendar.MONTH);
//        log.info("Month: " + month);
//        return month;
//    }
//
//    public int getTodayDay() {
//        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//        log.info("Day: " + day);
//        return day;
//    }

    public int getCallendarActualYear(WebDriver driver) {
        wait.waitForElVisible(driver, actualVisibleYear);
        String actualYear = actualVisibleYear.getText();
        return Integer.parseInt(actualYear);
    }

    public int getCallendarActualMonth(WebDriver driver) {
        wait.waitForElVisible(driver, actualVisibleMonth);
        String actualmonth = actualVisibleMonth.getText();
        int actualIntMonth = castStringToInt(actualmonth);
        return actualIntMonth;
    }

    public void getTodayDate() {
        dataPickerInput.click();
        todayDate.click();
    }

    public void clickOnInput() {
        dataPickerInput.click();
    }

    public void pickAday(WebDriver driver, int chosenDay) {
        wait.waitForElsVisible(driver, defaultDaysOfCurrentMonth);
        for (WebElement day : defaultDaysOfCurrentMonth) {
            String text = day.getText();
            int dayValue = Integer.parseInt(text);
            if (dayValue == (chosenDay)) {
                day.click();
            }
        }
    }

    public void getChosendate(WebDriver driver, int year, int month, int chosenDay) {
        clickOnInput();
        while (true) {
            if (getCallendarActualYear(driver) == (year) & getCallendarActualMonth(driver) == (month)) {
                break;
            } else {
                checkYear(driver, year, month, chosenDay);
            }
        }
        pickAday(driver, chosenDay);
    }

    public void checkYear(WebDriver driver, int year, int month, int chosenDay) {
        while (true) {
            if (getCallendarActualYear(driver) == year) {
                break;
            } else if (getCallendarActualYear(driver) < year) {
                wait.waitForElVisible(driver, nextMontharrow);
                nextMontharrow.click();
            } else {
                prevMontharrow.click();
            }

        }
        checkMonth(driver, month, chosenDay);


    }

    public void checkMonth(WebDriver driver, int month, int chosenDay) {
        while (true) {
            if ((getCallendarActualMonth(driver)) == (month)) {
                break;
            } else if ((getCallendarActualMonth(driver)) < (month)) {
                wait.waitForElVisible(driver, nextMontharrow);
                nextMontharrow.click();

            } else {
                wait.waitForElVisible(driver, prevMontharrow);
                prevMontharrow.click();
            }
            break;
        }
    }


    public int castStringToInt(String month) {
        switch (month) {
            case "January":
                month = "1";
                break;
            case "Febuary":
                month = "2";
                break;
            case "March":
                month = "3";
                break;
            case "April":
                month = "4";
                break;
            case "May":
                month = "5";
                break;
            case "June":
                month = "6";
                break;
            case "July":
                month = "7";
                break;
            case "August":
                month = "8";
            case "September":
                month = "9";
            case "October":
                month = "10";
            case "November":
                month = "11";
            case "December":
                month = "12";
        }
        return Integer.parseInt(month);
    }
}