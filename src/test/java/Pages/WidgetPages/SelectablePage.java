package Pages.WidgetPages;

import Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;

public class SelectablePage {
    @FindBy(id = "speed-button")
    WebElement speedButton;
    @FindBy(id = "speed")
    WebElement speedDropdown;
    Select speed = new Select(speedDropdown);

    @FindBy(id = "files-button")
    WebElement fileDropdown;
    @FindBy(id = "files")
            WebElement fileSelect;
    Select file = new Select(fileSelect);
    @FindBy(id = "number")
    WebElement number;
    @FindBy(id = "salutation")
    WebElement title;

    public SelectablePage() {
    }

    public WebElement getFileSelect() {
        return fileSelect;
    }

    public WebElement getSpeedButton() {
        return speedButton;
    }

    public Select getSpeed() {
        return speed;
    }

    public Select getFile() {
        return file ;
    }

    public WebElement getNumber() {
        return number;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getSpeedDropdown() {
        return speedDropdown;
    }

    public void getRandomSelect(Select select) {
        select.selectByIndex(new Random().nextInt(select.getOptions().size()));
    }

    public void selectOptionbyText(String text) {
             fileDropdown.click();

    }

}
