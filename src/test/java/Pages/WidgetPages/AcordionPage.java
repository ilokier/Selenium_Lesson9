package Pages.WidgetPages;

import Heplers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AcordionPage {
    WaitHelper wait = new WaitHelper();
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    @FindBy(css = ".ui-accordion-header")
    List<WebElement> accordion;
    @FindBy(css = "div>p")
    List<WebElement> accTextTab;

    public List<WebElement> getAccTextTab() {
        return accTextTab;
    }

    public void clickAccordion(int index) {
        accordion.get(index).click();
    }

    public String getAccordionText(int index, WebDriver driver) {
        int size = accTextTab.size();
        wait.waitForElVisible(driver, getAccTextTab().get(index));
        log.info(String.valueOf(size));
        return accTextTab.get(index).getText();
    }

}

