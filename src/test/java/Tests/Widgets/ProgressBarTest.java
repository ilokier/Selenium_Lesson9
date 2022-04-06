package Tests.Widgets;

import Pages.WidgetPages.ProgressBarPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProgressBarTest extends BaseTest {
    String url = "https://seleniumui.moderntester.pl/progressbar.php";
    private ProgressBarPage progressBarPage;

    @BeforeEach
    public void before() {
        driver.get(url);
        progressBarPage = PageFactory.initElements(driver, ProgressBarPage.class);
    }

    @Test
    public void afterLoadingProgressBarShouldBeComplete() {
        String progressbarText = progressBarPage.loadProgressBar(driver);
        assertThat(progressbarText, equalTo("Complete!"));
    }

}
