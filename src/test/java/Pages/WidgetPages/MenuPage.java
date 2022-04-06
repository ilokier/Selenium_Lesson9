package Pages.WidgetPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
    @FindBy(id = "ui-id-9")
    private WebElement music;
    @FindBy(id = "ui-id-13")
    private WebElement jazz;
    @FindBy(id = "ui-id-16")
    private WebElement modern;

    public void choseMenu(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);

        action.moveToElement(element);
        action.perform();
    }

    public WebElement getMusic() {
        return music;
    }

    public WebElement getJazz() {
        return jazz;
    }

    public WebElement getModern() {
        return modern;
    }

    public String getTextFromMenuOption(WebElement element) {
        return element.getText();
    }
}