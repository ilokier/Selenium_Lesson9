package Pages;

import Heplers.RandomHelper;
import Heplers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    private List<WebElement> professionList;
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
    @FindBy(id = "validator-message")
    WebElement validatorMsg;
    RandomHelper randomHelper = new RandomHelper();
    WaitHelper wait = new WaitHelper();


    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getValidatorMsg() {
        return validatorMsg.getText();
    }

    public FormPage setFirstName(String firstname) {
        firstName.sendKeys(firstname);
        return this;
    }

    public FormPage setLastName(String lastname) {
        lastName.sendKeys(lastname);
        return this;
    }

    public FormPage setEmail(String email) {
        eMail.sendKeys(email);
        return this;
    }

    public FormPage chooseSex() {
        randomHelper.getRandomElement(sex).click();
        return this;
    }

    public FormPage setAge(String age) {
        this.age.clear();
        this.age.sendKeys(age);
        return this;
    }

    public FormPage chooseExperience() {
        randomHelper.getRandomElement(yearsOfExp).click();
        return this;
    }

    public FormPage chooseProfession(int proffesionIndex) {
        professionList.get(1).click();
        return this;
    }

    public FormPage selectContinent(String continent) {
        chooseSelectOption(continent, selectContinent);
        return this;
    }

    public FormPage attachFile(String path) {
        File file = new File(path);
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage selectSeleniumComands(WebDriver driver, String seleniumCommand1, String seleniumCommand2) {
        wait.waitForElVisible(driver, seleniumComands);
        chooseSelectOption(seleniumCommand1, seleniumComands);
        chooseSelectOption(seleniumCommand2, seleniumComands);
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
