package Tests.Widgets;

import Pages.WidgetPages.DataPickerPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

public class DataPickerTest extends BaseTest {

    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/datepicker.php";

    List<String> results;
    Set<String> allWindows;
    private DataPickerPage dataPickerPage;
    //private SelectMethods widgetPage = new SelectMethods();

    @BeforeEach
    public void before() {
        driver.get(url);
       dataPickerPage = PageFactory.initElements(driver, DataPickerPage.class);
    }

    @Test
    public void shouldPassChosenDateToInput() {
        driver.get(url);
        dataPickerPage.pickAdate(dataPickerPage.getTodayDate());
        log.info(dataPickerPage.getDataPickerInput().getText());
        // TODO: 01.04.2022 finish
    }

}

