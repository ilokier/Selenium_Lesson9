package Pages.WidgetPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutocompletePage {
    @FindBy(id = "search")
    WebElement searchInput;
    @FindBy(id = ".ui-menu-item")
    List<WebElement> searchResults;

    public WebElement getSearchInput() {
        return searchInput;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void searchTekst(String searchTextValue) {
        searchInput.sendKeys(searchTextValue);
    }


//    public void getResult(List<WebElement> els) {
//        for (WebElement searchResult : searchResults) {
//            String text = searchResult.getText();

      //  }

    }
