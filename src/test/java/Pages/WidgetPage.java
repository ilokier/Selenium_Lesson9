package Pages;

import Tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class WidgetPage extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    List<String> texts;

    @FindBy(css = ".ui-accordion-header")
    List<WebElement> accordion;
    @FindBy(css = "#accordion p")
    List<WebElement> accTextTab;

    @FindBy(id = "search")
    WebElement searchInput;
    @FindBy(id = ".ui-menu-item")
    List<WebElement> searchResults;

    @FindBy(id = "datepicker")
    WebElement dataPickerInput;
    @FindBy(css = ".ui-datepicker-today")
    WebElement todayDate;
    @FindBy(css = ".ui-datepicker-next")
    WebElement nextMonthRight;

    @FindBy(css = "#menu")
    List<WebElement> menu;


    public WebElement getDataPickerInput() {
        return dataPickerInput;
    }

    public WebElement getTodayDate() {
        return todayDate;
    }

    public void getAccordionText() throws InterruptedException {
        for (WebElement acc : accordion) {
            acc.click();
            Thread.sleep(500);
            String text = accTextTab.get(0).getText();


            // String text = acc.getText();
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

            log.info(text);

            // }

        }
    }
//    public String getText(){
//        return accTextTab.getText();
//    }

    public List<WebElement> getMenu() {
        return menu;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void searchTekst(String searchTextValue) {
        searchInput.sendKeys(searchTextValue);
    }


    public void getSearchResult(List<WebElement> els) {
        for (WebElement searchResult : searchResults) {
            String text = searchResult.getText();
            System.out.println(text);

        }

    }

    public WebElement getRandomElement(List<WebElement>elements) {
        WebElement el = elements.get(new Random().nextInt(elements.size()));
        return el;
    }

    public void pickAdate(WebElement el){
        dataPickerInput.click();
        el.click();

    }
    public void pickMenuOption(int value){
        Actions action = new Actions(driver);
        action.moveToElement(menu.get(value));
        action.perform();


    }
}
