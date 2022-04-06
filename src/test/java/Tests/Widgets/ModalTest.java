package Tests.Widgets;

import Pages.WidgetPages.ModalPage;
import Pages.WindowHandlePage;
import Tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
import java.util.Set;

public class ModalTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/modal-dialog.php";
    private WindowHandlePage windowHandlePage = new WindowHandlePage();
    private ModalPage modalPage;

    @BeforeEach
    public void before() {
        modalPage = PageFactory.initElements(driver, ModalPage.class);
        windowHandlePage = PageFactory.initElements(driver, WindowHandlePage.class);
        driver.get(url);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/modalData.csv")
    public void shouldCreateNewUser(String name, String email, String password) {
        driver.get(url);
        windowHandlePage.switchWindow(modalPage.getCreateUserButton(), driver);
        modalPage.createNewUser(name, email, password);
        log.info("User data: "+name+", "+email+", "+password);
        modalPage.getDataFromTable();
        assertThat(modalPage.getDataFromTable(), equalTo(name));
    }
}
