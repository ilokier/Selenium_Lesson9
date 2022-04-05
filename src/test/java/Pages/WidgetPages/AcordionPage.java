package Pages.WidgetPages;


import Heplers.WaitHelper;
import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class AcordionPage extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    @FindBy(css = ".ui-accordion-header")
    List<WebElement> accordion;
    @FindBy(css = "#accordion p")
    List<WebElement> accTextTab;
    WaitHelper wait = new WaitHelper();

    public void clickAccordion() throws InterruptedException {
        for (WebElement acc : accordion) {
            acc.click();
            getAccordionText();
        }

    }
    public void getAccordionText(){
        for (WebElement ac : accTextTab) {
            String text = ac.getText();
            log.info(text);
                    }

    }
}

