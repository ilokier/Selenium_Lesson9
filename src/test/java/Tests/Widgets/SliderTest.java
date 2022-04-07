package Tests.Widgets;

import Pages.WidgetPages.SliderPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void shouldMoveSliderToGivenValue() {
        sliderPage.setSliderPosition(driver, 50);
        sliderPage.setSliderPosition(driver, 80);
        sliderPage.setSliderPosition(driver, 80);
        sliderPage.setSliderPosition(driver, 20);
        sliderPage.setSliderPosition(driver, 0);
        assertThat(sliderPage.getPositionValue(), equalTo(0));
    }
}