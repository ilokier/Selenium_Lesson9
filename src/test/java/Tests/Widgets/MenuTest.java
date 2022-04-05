package Tests.Widgets;

import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MenuTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/menu-item.php";


    @BeforeEach
    public void before() {
        driver.get(url);
    }

    @Test
    public void shouldgoToChosenMenuOption() {
        List<WebElement> menu = driver.findElements(By.cssSelector("#menu>li"));
        Actions action = new Actions(driver);
        action.moveToElement(menu.get(5));
        action.perform();
//todo finish

    }


}


