package Tests;

import Pages.AlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlertTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/alerts.php";
    String alertTekst;
    private AlertsPage alertsPage;

    @BeforeEach
    public void goToUrl() {
        alertsPage = PageFactory.initElements(driver, AlertsPage.class);
        driver.get(url);
    }

    @Test
    public void shouldHandleSimpleAlert() {
        alertsPage.acceptSimpleAllert(driver);
        alertTekst = alertsPage.getSimpleAllertMessage();
        assertThat(alertTekst, equalTo("OK button pressed"));
    }

    @Test
    public void shouldHandlePromptAlert() {
        alertsPage.acceptPromptAllert(driver, "Lord Vader");
        alertTekst = alertsPage.getPromptAllertMessage();
        assertThat(alertTekst, equalTo("Hello Lord Vader! How are you today?"));
    }

    @Test
    public void shouldHandleConfirmAlertAccept() {
        alertsPage.acceptConfirmAllert(driver);
        alertTekst = alertsPage.getConfirmAllertMessage();
        assertThat(alertTekst, equalTo("You pressed OK!"));
    }

    @Test
    public void shouldHandleConfirmAlertDismiss() {
        alertsPage.dissmissConfirmAllert(driver);
        alertTekst = alertsPage.getConfirmAllertMessage();
        assertThat(alertTekst, equalTo("You pressed Cancel!"));
    }

    @Test
    public void shouldHandleDelayedAlert() {
        alertsPage.acceptDelayAllert(driver);
        alertTekst = alertsPage.getDelayAllertMessage();
        assertThat(alertTekst, equalTo("OK button pressed"));
    }

}
