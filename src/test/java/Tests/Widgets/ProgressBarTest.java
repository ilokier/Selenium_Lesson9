package Tests.Widgets;

import Heplers.WaitHelper;
import Pages.WidgetPages.ProgressBarPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProgressBarTest extends BaseTest {
    String url = "https://seleniumui.moderntester.pl/progressbar.php";
    WaitHelper wait = new WaitHelper();
    private ProgressBarPage progressBarPage;

    @BeforeEach
    public void before() {
        driver.get(url);
        progressBarPage = PageFactory.initElements(driver, ProgressBarPage.class);
    }

    @Test
    public void afterLoadingProgressBarShouldBeComplete() {
        wait.waitArributeValue(driver, progressBarPage.getProgressBar(), "class", "ui-progressbar-complete");
        assertThat(progressBarPage.getProgressBarLabel().getText(), equalTo("Complete!"));
    }

}
