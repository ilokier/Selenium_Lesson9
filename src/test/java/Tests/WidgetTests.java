package Tests;

import Pages.WidgetPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WidgetTests extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/accordion.php";
    List<String> results;

    private WidgetPage widgetPage = new WidgetPage();

    @BeforeEach
    public void before() {
        driver.get(url);
        String windowHandle = driver.getWindowHandle();
        widgetPage = PageFactory.initElements(driver, WidgetPage.class);
    }

    @Test
    public void choosingEachTabShouldReturnProperText() throws InterruptedException {
        widgetPage.getAccordionText();

    }

    @Test
    public void checkSearchResults() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        widgetPage.searchTekst("a");
        Thread.sleep(5000);
        // TODO: 04.04.2022 add wait 
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".ui-menu-item"));
        for (WebElement searchResult : searchResults) {
            String result = searchResult.getText();
            System.out.println(result);
        }
        WebElement random = widgetPage.getRandomElement(searchResults);
        log.info(random.getText());
        random.click();
        assertThat(random.getText(), equalTo(widgetPage.getSearchInput().getText()));

    }

    @Test
    public void shouldPassChosenDateToInput() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        widgetPage.pickAdate(widgetPage.getTodayDate());
        log.info(widgetPage.getDataPickerInput().getText());
        // TODO: 01.04.2022 finish 
    }

    @Test
    public void shouldgoToChosenMenuOption() {
        driver.get("https://seleniumui.moderntester.pl/menu-item.php");
        List<WebElement> menu = driver.findElements(By.cssSelector("#menu>li"));
        Actions action = new Actions(driver);
        action.moveToElement(menu.get(5));
        action.perform();
//todo finish

    }
}