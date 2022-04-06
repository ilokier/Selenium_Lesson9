package Pages.WidgetPages;

import Heplers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
    WaitHelper wait = new WaitHelper();

    @FindBy(id = "ui-id-9")
    private WebElement music;
    @FindBy(id = "ui-id-13")
    private WebElement jazz;
    @FindBy(id = "ui-id-16")
    private WebElement modern;

    public void choseMenu(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        wait.waitForElVisible(driver, element);
        action.moveToElement(element);
        action.perform();
    }
    public void choseMusicJazzModern(WebDriver driver){
        choseMenu(driver, music);
        choseMenu(driver, jazz);
        choseMenu(driver, modern);
        modern.click();
    }

}