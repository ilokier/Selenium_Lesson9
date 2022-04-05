package Tests.Widgets;


import Pages.WidgetPages.AcordionPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcordionTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/accordion.php";
    private AcordionPage acordionPage;

    @BeforeEach
    public void before() {
        driver.get(url);
        acordionPage = PageFactory.initElements(driver, AcordionPage.class);
    }

    @Test
    public void choosingEachTabShouldReturnProperText() throws InterruptedException {
        acordionPage.clickAccordion();
        // TODO: 04.04.2022 assertion
    }


}
