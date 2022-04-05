package Pages;

import Tests.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertsPage extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");

    @FindBy(id = "simple-alert")
    WebElement simpleAllertButton;
    @FindBy(id = "simple-alert-label")
    WebElement simpleMessage;

    @FindBy(id = "prompt-alert")
    WebElement promptAllertButton;
    @FindBy(id = "prompt-label")
    WebElement promptMessage;

    @FindBy(id = "confirm-label")
    WebElement confirmMessage;
    @FindBy(id = "confirm-alert")
    WebElement confirmAllertButton;
    @FindBy(id = "delayed-alert")
    WebElement delayedAllertButton;
    @FindBy(id = "delayed-alert-label")
    WebElement delayedMessage;


    public void goToAlert(WebElement el) {
        el.click();
    }

    public Alert switchToAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert;
    }

    public void enterNameToAllert(Alert al, String name) {
        al.sendKeys(name);
    }

    public String getAlertText(WebElement el) {
        return el.getText();
    }

    public WebElement getSimpleMessage() {
        return simpleMessage;
    }

    public WebElement getPromptMessage() {
        return promptMessage;
    }

    public WebElement getConfirmMessage() {
        return confirmMessage;
    }

    public WebElement getDelayedMessage() {
        return delayedMessage;
    }


    public WebElement getSimpleAllertButton() {
        return simpleAllertButton;
    }

    public WebElement getPromptAllertButton() {
        return promptAllertButton;
    }

    public WebElement getConfirmAllertButton() {
        return confirmAllertButton;
    }

    public WebElement getDelayedAllertButton() {
        return delayedAllertButton;
    }
}


