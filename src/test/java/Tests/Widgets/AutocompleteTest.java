package Tests.Widgets;

import Heplers.WaitHelper;
import Pages.WidgetPages.AutocompletePage;
import Heplers.RandomHelper;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutocompleteTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/autocomplete.php";
    List<String> results;
    Set<String> allWindows;
    private AutocompletePage autocompletePage;
    private RandomHelper randomHelper = new RandomHelper();
    WaitHelper wait = new WaitHelper();

    @BeforeEach
    public void before() {
        driver.get(url);
        autocompletePage = PageFactory.initElements(driver, AutocompletePage.class);
    }

    @Test
    public void checkSearchResults() {
        autocompletePage.searchTekst("a");
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".ui-menu-item"));
        wait.waitForElsVisible(driver,searchResults);
        for (WebElement searchResult : searchResults) {
            String result = searchResult.getText();
            log.info(result);
        }
        WebElement random = randomHelper.getRandomElement(searchResults);
        log.info("Random value is "+random.getText());
        random.click();
        assertThat(random.getText(), equalTo(autocompletePage.getSearchInput().getText()));

}
}
