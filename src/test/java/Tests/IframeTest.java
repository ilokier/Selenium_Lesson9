package Tests;

import Pages.FormPage;
import Pages.IFramePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IframeTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/iframes.php#";
    private FormPage formPage;
    private IFramePage iFramePage;

    @BeforeEach
    public void goToUrl() {
        iFramePage = PageFactory.initElements(driver, IFramePage.class);
        formPage = PageFactory.initElements(driver, FormPage.class);
        driver.get(url);
    }

    @Test
    public void properFillFormSholudSignIn(){
        driver.switchTo().frame(iFramePage.getIframe1());
        iFramePage.fillIframe1Form("Adam", "Nowak");
        formPage.submitForm();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFramePage.getIframe2());
        iFramePage.fillIframe2Form("adamnowak", "1234", "europe", 1);
        formPage.submitForm();
        driver.switchTo().defaultContent();
        log.info("Im on a main frame");
        assertThat(iFramePage.getBasic().getText(),equalTo("Basic"));
    }
}