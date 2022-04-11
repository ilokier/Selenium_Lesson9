package Tests;

import Pages.FormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String url = "https://seleniumui.moderntester.pl/form.php";

    @BeforeEach
    public void before() {
        driver.get(url);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/formData.csv")
    public void shouldFillFormWithSuccess(String firstName, String lastName, String email, String age, int prof, String continent, String seleniumCommand1, String seleniumCommand2, String path, String expectedMsg) {
        FormPage formPage = new FormPage(driver);
        formPage.setFirstName((firstName))
                .setLastName((lastName))
                .setEmail((email))
                .chooseSex()
                .setAge(age)
                .chooseExperience()
                .chooseProfession(prof)
                .selectContinent(continent)
                .selectSeleniumComands(driver, seleniumCommand1, seleniumCommand2)
                .attachFile(path);
        formPage.submitForm();
        String msg = formPage.getValidatorMsg();
        log.info("Validator message is: " + msg);
        assertThat(msg, equalTo(expectedMsg));
    }


}
