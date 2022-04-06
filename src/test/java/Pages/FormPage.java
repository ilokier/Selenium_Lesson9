package Pages;

import Heplers.RandomHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormPage {
    @FindBy(css = "#inputFirstName3")
    private WebElement firstName;
    @FindBy(id = "inputLastName3")
    private WebElement lastName;
    @FindBy(css = "#inputEmail3")
    private WebElement eMail;
    @FindBy(id = "inputAge3")
    private WebElement age;
    @FindBy(id = "gridRadios1")
    private List<WebElement> yearsOfExp;
    @FindBy(id = "gridRadiosMale")
    private List<WebElement> sex;
    @FindBy(css = "[name=gridCheckboxProfession]")
    private List<WebElement> profession;
    @FindBy(id = "selectContinents")
    private WebElement selectContinent;
    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumComands;
    @FindBy(id = "chooseFile")
    private WebElement fileInput;
    @FindBy(id = "additionalInformations")
    private WebElement additionalInformation;
    @FindBy(css = ".btn-secondary")
    private WebElement testFileDownloadButton;
    @FindBy(css = ".btn-primary")
    private WebElement signInButton;
    RandomHelper randomHelper = new RandomHelper();

    public WebElement getValidatorMsg() {
        return validatorMsg;
    }

    @FindBy(id = "validator-message")
    WebElement validatorMsg;

    public FormPage fillForm(String firstname, String lastname, String email, int prof, String continent, String value1, String value2, File file) {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        eMail.sendKeys(email);
        randomHelper.getRandomElement(sex).click();
        age.clear();
        age.sendKeys(String.valueOf(randomHelper.getRandomInt(100)));
        randomHelper.getRandomElement(yearsOfExp).click();
        profession.get(prof).click();
        chooseSelectOption(continent, selectContinent);
        chooseSelectOption(value1, seleniumComands);
        chooseSelectOption(value2, seleniumComands);
        fileInput.sendKeys(file.getAbsolutePath());

        return this;
    }

    public void submitForm() {
        signInButton.click();
    }

    public void chooseSelectOption(String value, WebElement el) {
        Select sel = new Select(el);
        sel.selectByValue(value);
    }

}
