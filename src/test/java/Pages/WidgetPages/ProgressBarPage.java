package Pages.WidgetPages;

import Tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage {

    @FindBy(css = ".ui-progressbar-value")
    WebElement progressBar;
    @FindBy(css = ".progress-label")
    WebElement progressBarLabel;

    public WebElement getProgressBar() {
        return progressBar;
    }

    public WebElement getProgressBarLabel() {
        return progressBarLabel;
    }
}