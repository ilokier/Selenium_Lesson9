package Tests;

import Heplers.WaitHelper;
import Pages.AlertsPage;
import Pages.TablePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TableTest extends BaseTest{
    String url = "https://seleniumui.moderntester.pl/table.php";
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    WaitHelper wait = new WaitHelper();
    private TablePage tablePage;

    @BeforeEach
    public void goToUrl() {
        tablePage = PageFactory.initElements(driver, TablePage.class);
        driver.get(url);
    }

    @Test
    public void printChosenValues(){
        tablePage.getPeak("Switzerland", 4000);
    }
}
