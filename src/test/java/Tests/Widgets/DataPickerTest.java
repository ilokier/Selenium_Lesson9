package Tests.Widgets;

import Pages.WidgetPages.DataPickerPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataPickerTest extends BaseTest {

    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/datepicker.php";

    private DataPickerPage dataPickerPage;

    @BeforeEach
    public void before() {
        driver.get(url);
        dataPickerPage = PageFactory.initElements(driver, DataPickerPage.class);
    }

    @Test
    public void shouldPassChosenDateToInput() {
        //  dataPickerPage.getTodayDate();
        dataPickerPage.getChosendate(driver, 2022, 5, 20);
        dataPickerPage.getChosendate(driver, 2023, 5, 20);

        // dataPickerPage.getChosendate(driver, 2022, 6, 22);

        // TODO: 01.04.2022 finish
    }

}

