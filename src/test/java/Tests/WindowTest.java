package Tests;

import Pages.WindowHandlePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WindowTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/windows-tabs.php";
    Set<String> allWindows;
    private WindowHandlePage windowHandlePage;

    @BeforeEach
    public void before() {
        driver.get(url);
        String windowHandle = driver.getWindowHandle();
        windowHandlePage = PageFactory.initElements(driver, WindowHandlePage.class);
    }

    @Test
    public void shouldGoToNewBrowserWindow() {
        windowHandlePage.switchWindow(windowHandlePage.getNewBrowserButton(), driver);
        String currentUrl = driver.getCurrentUrl();
        log.info("Current url is " + currentUrl);
        assertThat(currentUrl, equalTo("http://automation-practice.emilos.pl/"));
        //todo: do test with tables
        driver.close();
    }

    @Test
    public void shouldGoToNewMessageWindow() {
        windowHandlePage.switchWindow(windowHandlePage.getNewMsgButton(), driver);
        String msg = windowHandlePage.getMsgWindowBody();
        log.info("New window message is: " + msg);
        assertThat(msg, equalTo("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));
        driver.close();
    }
    @Test
    public void shouldGoToNewBrowserTab(){
        windowHandlePage.switchWindow(windowHandlePage.getNewTabButton(), driver);
        String currentUrl = driver.getCurrentUrl();
        log.info("Current url is " + currentUrl);
        assertThat(currentUrl, equalTo("http://automation-practice.emilos.pl/"));
        //todo: do test with tables
        driver.close();
    }

}
