package Pages.WidgetPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalPage {
    @FindBy(id = "create-user")
    WebElement createUserButton;
    @FindBy(id = "name")
    WebElement nameInput;
    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Create an account']")
    WebElement submitButton;
    @FindBy(css = "#users tr")
    WebElement usersTable;

    public WebElement getCreateUserButton() {
        return createUserButton;
    }
    public void createNewUser(String name, String email, String password) throws InterruptedException {
        nameInput.clear();
        nameInput.sendKeys(name);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
