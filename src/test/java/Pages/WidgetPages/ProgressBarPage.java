package Pages.WidgetPages;

import Heplers.WaitHelper;
import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage {
    WaitHelper wait = new WaitHelper();

    @FindBy(css = ".ui-progressbar-value")
    WebElement progressBar;
    @FindBy(css = ".progress-label")
    WebElement progressBarLabel;


    public String loadProgressBar(WebDriver driver){
        wait.waitArributeValue(driver, progressBar, "class", "ui-progressbar-complete");
        return progressBarLabel.getText();
    }
}