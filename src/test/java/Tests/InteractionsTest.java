package Tests;

import Pages.InteractionsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class InteractionsTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    String dragUrl = "https://seleniumui.moderntester.pl/draggable.php";
    String dropUrl = "https://seleniumui.moderntester.pl/droppable.php";
    String resizableUrl = "https://seleniumui.moderntester.pl/resizable.php";
    String selectUrl = "https://seleniumui.moderntester.pl/selectable.php";
    Actions action;

    private InteractionsPage interactionsPage;

    @BeforeEach
    public void before() {
        interactionsPage = PageFactory.initElements(driver, InteractionsPage.class);
         action = new Actions(driver);
    }

    @ParameterizedTest
    @CsvSource({"top right!, 900, -100",
            "bottom right!, 900, 350",
            "centre!, 400, 180"})
    public void shouldDragSquareToGivenDirection(String direction, int x, int y) {
        driver.get(dragUrl);
        action.dragAndDropBy(interactionsPage.getSquare(), x, y).perform();
        log.info("I drag square to the " + direction);
    }

    @Test
    public void shouldDropSquareToChosenArea() {
        driver.get(dropUrl);
        action.dragAndDrop(interactionsPage.getSquare(), interactionsPage.getDropPlace()).perform();
        String dropMsg = interactionsPage.getDropPlace().getText();
        assertThat(dropMsg, equalTo("Dropped!"));
        log.info("Square was succesfully " + dropMsg);
    }

    @ParameterizedTest
    @CsvSource({"0, resized to right!, 10, 0",
            "1, resized bottom!, 0, 10",
            "2, resized bottom and right!, 10, 10"})
    public void shouldResizeElement(int index, String direction, int x, int y) {
        driver.get(resizableUrl);
        action.clickAndHold(interactionsPage.choseListEl(interactionsPage.getResizableDirs(), index)).moveByOffset(x, y).perform();
        log.info("I got sguare " + direction);
    }

    @ParameterizedTest
    @CsvSource({"0,1",
            "2, 3",
            "3, 4"})
    public void shouldSelectChosenOptions(int index, String chosenNr) {
        driver.get(selectUrl);
        interactionsPage.choseListEl(interactionsPage.getSelect(), index).click();
        log.info("You chose Item " + chosenNr);
        assertThat(interactionsPage.getFeedbackNr().getText(), equalTo("#" + chosenNr));

    }
}

