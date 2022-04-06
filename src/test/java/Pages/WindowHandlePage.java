package Pages;

import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class WindowHandlePage extends BaseTest {
    @FindBy(id = "newBrowserWindow")
    private WebElement newBrowserButton;
    @FindBy(id = "newMessageWindow")
    private WebElement newMsgButton;
    @FindBy(id = "newBrowserTab")
    private WebElement newTabButton;

    public String getMsgWindowBody() {
        return msgWindowBody.getText();
    }

    @FindBy(css = "body")
    WebElement msgWindowBody;

    public WebElement getNewBrowserButton() {
        return newBrowserButton;
    }

    public WebElement getNewMsgButton() {
        return newMsgButton;
    }

    public WebElement getNewTabButton() {
        return newTabButton;
    }

    public void switchWindow(WebElement el, WebDriver driver) {
        el.click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String currentWindow : allWindows) {
            driver.switchTo().window(currentWindow);

        }

    }
}
