package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    @FindBy(css = "tbody tr")
    private List<WebElement> rows;



    public void getPeak(String chosenState, int chosenHight) {
        for (WebElement row : rows) {
            String state = row.findElement(By.xpath("./td[3]")).getText();
            int height = Integer.parseInt(row.findElement(By.xpath("./td[4]")).getText());
            if (state.equalsIgnoreCase(chosenState) && height > chosenHight) {
                List<WebElement> cols = row.findElements(By.cssSelector("td"));
                WebElement rank = row.findElement(By.cssSelector("th"));
                printValues(cols, rank);
            }
        }
    }

    public void printValues(List<WebElement> list, WebElement el) {
        String rank = el.getText();
        String peak = list.get(0).getText();
        String mountainRange = list.get(1).getText();
        String state = list.get(2).getText();
        String height = list.get(3).getText();
        String result = ("Rank: " + rank + " Peak :" + peak + " Mountain range: " + mountainRange);
        System.out.println(result);
    }


}
