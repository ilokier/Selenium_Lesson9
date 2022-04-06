package Tests.Widgets;

import Heplers.WaitHelper;
import Pages.WidgetPages.MenuPage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MenuTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/menu-item.php";
    private MenuPage menuPage;

    @BeforeEach
    public void before() {
        driver.get(url);
        menuPage = PageFactory.initElements(driver, MenuPage.class);
    }

    @Test
    public void shouldChooseJazz() {
        menuPage.choseMusicJazzModern(driver);
    }
}



