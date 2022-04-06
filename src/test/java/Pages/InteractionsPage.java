package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InteractionsPage {
    @FindBy(id = "draggable")
    private WebElement square;
    @FindBy(id = "droppable")
    private WebElement dropPlace;
    @FindBy(css = ".ui-resizable-handle")
   private List<WebElement> resizableDirs;

    @FindBy(css = ".ui-selectee")
    private List<WebElement> select;
    @FindBy(css = "#select-result")
    private WebElement feedbackNr;

    @FindBy(css = ".ui-sortable-handle")
    private List<WebElement> sortedList;


    public List<WebElement> getResizableDirs() {
        return resizableDirs;
    }

    public List<WebElement> getSelect() {
        return select;
    }

    public WebElement getDropPlace() {
        return dropPlace;
    }

    public WebElement getSquare() {
        return square;
    }

    public WebElement getFeedbackNr() {
        return feedbackNr;
    }

    public WebElement choseListEl(List<WebElement> list, int index) {
        return list.get(index);

    }
}


