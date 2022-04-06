package Tests;

import Pages.TablePage;
import Pages.WindowHandlePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    private TablePage tablePage;

    @BeforeEach
    public void before() {
        driver.get(url);
        String windowHandle = driver.getWindowHandle();
        windowHandlePage = PageFactory.initElements(driver, WindowHandlePage.class);
        tablePage = PageFactory.initElements(driver, TablePage.class);
    }

    @Test
    public void shouldGoToNewBrowserWindow() {
        windowHandlePage.switchWindow(windowHandlePage.getNewBrowserButton(), driver);
        String currentUrl = driver.getCurrentUrl();
        log.info("Current url is " + currentUrl);
        driver.navigate().to("https://seleniumui.moderntester.pl/table.php");
        tablePage.getPeak("Switzerland", 4000);
        currentUrl = driver.getCurrentUrl();
        log.info("Current url is: " + currentUrl);
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
    public void shouldGoToNewBrowserTab() {
        windowHandlePage.switchWindow(windowHandlePage.getNewTabButton(), driver);
        String currentUrl = driver.getCurrentUrl();
        log.info("Current url is " + currentUrl);
        driver.navigate().to("https://seleniumui.moderntester.pl/table.php");
        tablePage.getPeak("Switzerland", 4000);
        currentUrl = driver.getCurrentUrl();
        log.info("Current url is " + currentUrl);
        assertThat(currentUrl, equalTo("https://seleniumui.moderntester.pl/table.php"));
        driver.close();
    }
}
