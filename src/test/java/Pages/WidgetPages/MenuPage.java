package Pages.WidgetPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class MenuPage {
    @FindBy(css = "#menu")
    List<WebElement> menu;
}