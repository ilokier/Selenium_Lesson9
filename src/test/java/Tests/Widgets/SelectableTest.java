package Tests.Widgets;

import Heplers.WaitHelper;
import Heplers.RandomHelper;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectableTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/selectmenu.php";
    RandomHelper randomHelper = new RandomHelper();
    WaitHelper wait = new WaitHelper();

    @BeforeEach
    public void goToUrl() {
        driver.get(url);
    }

    @Test
    public void shouldSelectSpeed() {
        WebElement speedDropdown = driver.findElement(By.id("speed-button"));
        wait.waitForElVisible(driver, speedDropdown);
        WebElement speedSelect = driver.findElement(By.id("speed"));
        speedDropdown.click();
        Select speed = new Select(speedSelect);
        randomHelper.getRandomSelectOption(speed);
    }

    @Test
    public void shouldSelectFile() {
        WebElement fileDropdown = driver.findElement(By.id("files-button"));
        wait.waitForElVisible(driver, fileDropdown);
        WebElement fileSelect = driver.findElement(By.id("files"));
        fileDropdown.click();
        Select file = new Select(fileSelect);
        file.selectByVisibleText("jQuery.js");
    }

    @Test
    public void shouldSelectNumber() {
        WebElement numberDropdown = driver.findElement(By.id("number-button"));
        wait.waitForElVisible(driver, numberDropdown);
        WebElement numberSelect = driver.findElement(By.id("number"));
        numberDropdown.click();
        Select file = new Select(numberSelect);
        file.selectByIndex(1);
    }

    @Test
    public void shouldSelectTitle() {
        WebElement titleDropdown = driver.findElement(By.id("salutation-button"));
        wait.waitForElVisible(driver, titleDropdown);
        WebElement titleSelect = driver.findElement(By.id("salutation"));
        titleDropdown.click();
        Select title = new Select(titleSelect);
        randomHelper.getRandomSelectOption(title);
    }

}



