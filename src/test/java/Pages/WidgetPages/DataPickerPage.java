package Pages.WidgetPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;

public class DataPickerPage {
    @FindBy(id = "datepicker")
    WebElement dataPickerInput;
    @FindBy(css = ".ui-datepicker-today")
    WebElement todayDate;
    @FindBy(css = ".ui-datepicker-next")
    WebElement nextMonthRight;


    public WebElement getDataPickerInput() {
        return dataPickerInput;
    }

    public WebElement getTodayDate() {
        return todayDate;
    }

    public void pickAdate(WebElement el){
        dataPickerInput.click();
        el.click();

    }
}