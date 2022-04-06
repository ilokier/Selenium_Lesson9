package Tests.Widgets;

import Pages.WidgetPages.SliderPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SliderTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/slider.php";

    private SliderPage sliderPage;

    @BeforeEach
    public void before() {
        driver.get(url);
        sliderPage = PageFactory.initElements(driver, SliderPage.class);
    }

    @ParameterizedTest
    @CsvSource({"545, 50", "873, 80", "873, 80", "212, 20", "0, 0"})
    public void shouldMoveSlider(int x, String expectedValue) {
        Actions action = new Actions(driver);
        action.moveToElement(sliderPage.getSliderHandle(), x, 0).click().perform();
        log.info("Expected value is" + expectedValue);
        assertThat(sliderPage.getPositionValue(), equalTo(expectedValue));
        // TODO: 07.04.2022 make arrows, not pixels
    }

}