package Tests;

import Heplers.WaitHelper;
import Pages.AlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlertTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/alerts.php";
    String alertTekst;
    Alert al;
    WaitHelper wait = new WaitHelper();
    private AlertsPage alertsPage;

    @BeforeEach
    public void goToUrl() {
        alertsPage = PageFactory.initElements(driver, AlertsPage.class);
        driver.get(url);
    }

    @Test
    public void shouldHandleSimpleAlert() {
        alertsPage.goToAlert(alertsPage.getSimpleAllertButton());
        alertsPage.switchToAlert(driver).accept();
        alertTekst = alertsPage.getAlertText(alertsPage.getSimpleMessage());
        assertThat(alertTekst, equalTo("OK button pressed"));
    }

    @Test
    public void shouldHandlePromptAlert() {
        alertsPage.goToAlert(alertsPage.getPromptAllertButton());
        al = alertsPage.switchToAlert(driver);
        alertsPage.enterNameToAllert(al, "Lord Vader");
        al.accept();
        alertTekst = alertsPage.getAlertText(alertsPage.getPromptMessage());
        assertThat(alertTekst, equalTo("Hello Lord Vader! How are you today?"));
    }

    @Test
    public void shouldHandleConfirmAlertAccept() {
        alertsPage.goToAlert(alertsPage.getConfirmAllertButton());
        alertsPage.switchToAlert(driver).accept();
        alertTekst = alertsPage.getAlertText(alertsPage.getConfirmMessage());
        assertThat(alertTekst, equalTo("You pressed OK!"));
    }

    @Test
    public void shouldHandleConfirmAlertDismiss() {
        alertsPage.goToAlert(alertsPage.getConfirmAllertButton());
        alertsPage.switchToAlert(driver).dismiss();
        alertTekst = alertsPage.getAlertText(alertsPage.getConfirmMessage());
        assertThat(alertTekst, equalTo("You pressed Cancel!"));
    }

    @Test
    public void shouldHandleDelayedAlert() {
        alertsPage.goToAlert(alertsPage.getDelayedAllertButton());
        wait.waitForAlert(driver);
        alertsPage.switchToAlert(driver).accept();
        alertTekst = alertsPage.getAlertText(alertsPage.getDelayedMessage());
        assertThat(alertTekst, equalTo("OK button pressed"));

    }

}
