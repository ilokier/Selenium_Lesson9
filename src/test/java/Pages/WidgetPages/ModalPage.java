package Pages.WidgetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ModalPage {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");

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
    @FindBy(css = "tbody tr")
    List<WebElement> usersTable;

    String userName;


    public WebElement getCreateUserButton() {
        return createUserButton;
    }

    public void createNewUser(String name, String email, String password)  {
        nameInput.clear();
        nameInput.sendKeys(name);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public String getDataFromTable() {
        for (WebElement user : usersTable) {
            userName = user.findElement(By.xpath("./td[1]")).getText();
            log.info("Username in table is: "+userName);
        }
        return userName;
    }
}
