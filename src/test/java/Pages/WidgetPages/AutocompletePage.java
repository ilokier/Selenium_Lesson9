package Pages.WidgetPages;

import Heplers.RandomHelper;
import Heplers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AutocompletePage {
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");

    WaitHelper wait = new WaitHelper();
    RandomHelper random = new RandomHelper();
    String text;
    @FindBy(id = "search")
    private WebElement searchInput;
    @FindBy(css = ".ui-menu-item")
    private List<WebElement> searchResults;
    private WebElement randomEl;

    public void searchTekst(String searchTextValue) {
        searchInput.sendKeys(searchTextValue);
    }

    public String getSearchResults(WebDriver driver) {
        wait.waitForElsVisible(driver, searchResults);
        for (WebElement searchResult : searchResults) {
            text = searchResult.getText();
        }
        return text;
    }

    public WebElement getRandomResult() {
        randomEl = searchResults.get(random.getRandomInt(searchResults.size()));
        return randomEl;
    }

    public void choseElement(WebElement el) {
        el.click();
    }

    public String getSearchInputText() {
        String inputSearch = searchInput.getAttribute("value");
        log.info("Input text is: " + inputSearch);
        return inputSearch;
    }
}

