package Heplers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class RandomHelper {

    public RandomHelper() {
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public int getRandomSelectOption(Select sel) {
        int size = sel.getOptions().size();
        return new Random().nextInt(size);
    }

    public int getRandomInt(int i) {
        return new Random().nextInt(i);
    }

}

