package Pages.WidgetPages;

import Heplers.WaitHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SliderPage {
    WaitHelper wait = new WaitHelper();
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    @FindBy(id = "custom-handle")
    WebElement sliderHandle;
   
    public int getPositionValue() {
        int currentValue = Integer.parseInt((sliderHandle.getText()));
        return currentValue;
    }

    public void setSliderPosition(WebDriver driver, int expectedPosition) {
        int currentPosition = getPositionValue();

        if (currentPosition < expectedPosition) {
            goRight(driver, currentPosition, expectedPosition);
            log.info("Actual position is " + getPositionValue());

        } else if (currentPosition > expectedPosition) {
            goLeft(driver, currentPosition, expectedPosition);
            log.info("Actual position is " + getPositionValue());

        } else {
            log.info("Actual position is  " + currentPosition);
        }
    }

    public void goRight(WebDriver driver, int currentPosition, int expectedPosition) {
        for (int i = currentPosition; i < expectedPosition; i++) {
            wait.waitForElInteractavble(driver, sliderHandle);
            sliderHandle.sendKeys(Keys.ARROW_RIGHT);

        }
    }

    public void goLeft(WebDriver driver, int currentPosition, int expectedPosition) {
        for (int i = currentPosition; i > expectedPosition; i--) {
            wait.waitForElInteractavble(driver, sliderHandle);
            sliderHandle.sendKeys(Keys.ARROW_LEFT);

        }
    }
}