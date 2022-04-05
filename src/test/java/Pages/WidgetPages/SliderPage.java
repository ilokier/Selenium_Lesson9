package Pages.WidgetPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SliderPage {
    private static Logger log = LoggerFactory.getLogger("PageTitleTest.class");
    @FindBy(id = "custom-handle")
    WebElement sliderHandle;
    @FindBy(id = "slider")
    WebElement slider;

    public WebElement getSliderHandle() {
        return sliderHandle;
    }

    public String getPositionValue() {
        String currentValue = (slider.getText());
        log.info("Current value is " + currentValue);
        return currentValue;
    }


}
