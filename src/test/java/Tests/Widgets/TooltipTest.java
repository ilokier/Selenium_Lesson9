package Tests.Widgets;

import Pages.WidgetPages.TooltipPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TooltipTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/tooltip.php";

    private TooltipPage tooltipPage;

    @BeforeEach
    public void before() {
        driver.get(url);
        tooltipPage = PageFactory.initElements(driver, TooltipPage.class);
    }

    @Test
    public void shouldShowTip() {
        tooltipPage.goToAgeInput(driver);
        assertThat(tooltipPage.getTipMsg(), equalTo("We ask for your age only for statistical purposes."));
    }
}
