package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class IFramePage {


    @FindBy(css = "[name = iframe1]")
    WebElement iframe1;
@FindBy(id = "inputFirstName3")
WebElement name;
    @FindBy(id = "inputSurname3")
    WebElement surname;

    @FindBy(css = "[name = iframe2]")
    WebElement iframe2;
    @FindBy(id = "inputLogin")
    WebElement logIn;
    @FindBy(id = "inputPassword")
    WebElement inputPassword;
    @FindBy(id = "inlineFormCustomSelectPref")
    WebElement selectContinents;
    @FindBy(css = "[name=gridRadios]")
    List<WebElement> yearsOfExp;
    @FindBy(css = "li.nav-ite>a:first-child")
    WebElement basic;


    public WebElement getIframe1() {
        return iframe1;
    }

    public WebElement getIframe2() {
        return iframe2;
    }

    public WebElement getBasic() {
        return basic;
    }

    public void fillIframe1Form(String firstname, String lastname){
        name.sendKeys(firstname);
        surname.sendKeys(lastname);
    }
    public void fillIframe2Form(String login, String password, String continent, int years) {
        logIn.sendKeys(login);
        inputPassword.sendKeys(password);
        Select cont = new Select(selectContinents);
        cont.selectByValue(continent);
        yearsOfExp.get(years).click();

    }
    public void returnToBasic(){
        basic.click();
    }
}
