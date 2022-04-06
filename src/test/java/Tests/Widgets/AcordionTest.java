package Tests.Widgets;


import Heplers.WaitHelper;
import Pages.WidgetPages.AcordionPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AcordionTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/accordion.php";
    private AcordionPage acordionPage;
    WaitHelper wait = new WaitHelper();

    @BeforeEach
    public void before() {
        driver.get(url);
        acordionPage = PageFactory.initElements(driver, AcordionPage.class);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/accordionData.csv")
    public void choosingEachTabShouldReturnProperText(int index,int textIndex, String text) {
        acordionPage.clickAccordion(index);
        wait.waitForElVisible(driver, acordionPage.getAccTextTab().get(textIndex));
        String accordionTekst = acordionPage.getAccordionText(textIndex);
        assertThat(accordionTekst, equalTo(text));
    }
}
