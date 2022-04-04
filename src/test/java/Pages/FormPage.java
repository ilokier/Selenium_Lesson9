package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    @FindBy(css = "#inputFirstName3")
    WebElement firstName;
    @FindBy(id = "inputLastName3")
    WebElement lastName;
    @FindBy(css = "#inputEmail3")
    WebElement eMail;
    @FindBy(id = "inputAge3")
    WebElement age;
    @FindBy(id = "gridRadios1")
    List<WebElement> yearsOfExp;
    @FindBy(id = "gridRadiosMale")
    List<WebElement> sex;
    @FindBy(css = "[name=gridCheckboxProfession]")
    List<WebElement> profession;
    @FindBy(id = "selectContinents")
    WebElement selectContinent;
    @FindBy(id = "selectSeleniumCommands")
    WebElement seleniumComands;
    @FindBy(id = "chooseFile")
    WebElement fileInput;
    @FindBy(id = "additionalInformations")
    WebElement additionalInformation;
    @FindBy(css = ".btn-secondary")
    WebElement testFileDownloadButton;
    @FindBy(css = ".btn-primary")
    WebElement signInButton;

    public WebElement getValidatorMsg() {
        return validatorMsg;
    }

    @FindBy(id = "validator-message")
    WebElement validatorMsg;

    public FormPage fillForm(String firstname, String lastname, String email, int prof, String continent, String value1, String value2, File file) {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        eMail.sendKeys(email);
        getRandomElement(sex).click();
        age.clear();
        age.sendKeys(String.valueOf(getRandomInt(100)));
        getRandomElement(yearsOfExp).click();
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

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public int getRandomInt(int i) {
        return new Random().nextInt(i);
    }

    public void chooseSelectOption(String value, WebElement el) {
        Select sel = new Select(el);
        sel.selectByValue(value);
    }

}
