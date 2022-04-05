package Pages.WidgetPages;

import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TooltipPage extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    @FindBy(id = "age")
    WebElement ageInput;
    @FindBy(css = ".ui-tooltip-content")
    WebElement tip;

    public WebElement getAgeInput() {
        return ageInput;
    }

    public void fillAgeInput(String age) {
        ageInput.sendKeys(age);
    }

    public void goToAgeInput(WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(ageInput).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(tip));
    }

    public String getTipMsg() {
        String tipMsg = tip.getText();
        log.info(tipMsg);
        return tipMsg;
    }


}