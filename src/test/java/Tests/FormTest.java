package Tests;

import Pages.FormPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/form.php";
    private FormPage formPage;


    @ParameterizedTest
    @CsvFileSource(resources = "/formData.csv")
     public void shouldFillFormWithSuccess(String firstName, String lastName, String email, int prof, String continent, String value1, String value2, String expectedMsg, File file) {
        formPage = PageFactory.initElements(driver, FormPage.class);
        driver.get(url);
        formPage.fillForm(firstName, lastName, email, prof, continent, value1, value2, file);
        formPage.submitForm();
        String msg = formPage.getValidatorMsg().getText();
        log.info(msg);
        assertThat(msg, equalTo(expectedMsg));
    }

}
