package Tests.Widgets;

import Heplers.RandomHelper;
import Pages.WidgetPages.AutocompletePage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutocompleteTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/autocomplete.php";
    private AutocompletePage autocompletePage;
    private RandomHelper randomHelper = new RandomHelper();

    @BeforeEach
    public void before() {
        driver.get(url);
        autocompletePage = PageFactory.initElements(driver, AutocompletePage.class);
    }

    @Test
    public void checkSearchResults() {
        autocompletePage.searchTekst("a");
        autocompletePage.getSearchResults(driver);
        WebElement randomEl = autocompletePage.getRandomResult();
        String randomValue = randomEl.getText();
        log.info("Random search value is :" + randomValue);
        autocompletePage.choseElement(randomEl);
        String searchInputText = autocompletePage.getSearchInputText();
        assertThat(randomValue, equalTo(searchInputText));
    }
}
