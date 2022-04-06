package Pages;

import Heplers.WaitHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertsPage {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    Alert alert;
    WaitHelper wait = new WaitHelper();

    @FindBy(id = "simple-alert")
    private WebElement simpleAllertButton;
    @FindBy(id = "simple-alert-label")
    private WebElement simpleMessage;
    @FindBy(id = "prompt-alert")
    private WebElement promptAllertButton;
    @FindBy(id = "prompt-label")
    private WebElement promptMessage;
    @FindBy(id = "confirm-label")
    private WebElement confirmMessage;
    @FindBy(id = "confirm-alert")
    private WebElement confirmAllertButton;
    @FindBy(id = "delayed-alert")
    private WebElement delayedAllertButton;
    @FindBy(id = "delayed-alert-label")
    private WebElement delayedMessage;

    public Alert switchToAlert(WebDriver driver) {
        alert = driver.switchTo().alert();
        return alert;
    }

    public void acceptSimpleAllert(WebDriver driver) {
        simpleAllertButton.click();
        switchToAlert(driver).accept();
    }

    public String getSimpleAllertMessage() {
        return simpleMessage.getText();
    }

    public void acceptPromptAllert(WebDriver driver, String name) {
        promptAllertButton.click();
        switchToAlert(driver).sendKeys(name);
        alert.accept();
    }

    public String getPromptAllertMessage() {
        return promptMessage.getText();
    }

    public void acceptConfirmAllert(WebDriver driver) {
        confirmAllertButton.click();
        switchToAlert(driver).accept();
    }

    public void dissmissConfirmAllert(WebDriver driver) {
        confirmAllertButton.click();
        switchToAlert(driver).dismiss();
    }

    public String getConfirmAllertMessage() {
        return confirmMessage.getText();
    }

    public void acceptDelayAllert(WebDriver driver) {
        delayedAllertButton.click();
        wait.waitForAlert(driver);
        switchToAlert(driver).accept();
    }

    public String getDelayAllertMessage() {
        return delayedMessage.getText();
    }
}


