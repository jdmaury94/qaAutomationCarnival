package helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Helpers {
    public int formatStringToNumber(String string){
        return Integer.parseInt(string.substring(2,5));
    }

    public boolean checkSortedList(List<Integer> pricesList) {
        for(int i=0;i<pricesList.size()-1;i++){
            if(pricesList.get(i)>pricesList.get(i+1))
                return false;
        }
        return true;
    }

    public void sendKeysNTimes(int minPrice, int maxPrice, WebElement minBtn, WebElement maxBtn, WebDriver driver){
        Actions move = new Actions(driver);
        int timesToRight = (minPrice - 400)/10;
        int timesToLeft = (800 - maxPrice)/10;
        System.out.println(timesToRight);
        System.out.println(timesToLeft);
        minBtn.click();
        for(int i = 1;i<=timesToRight;i++){
            move.sendKeys(Keys.ARROW_RIGHT).build().perform();
        }
        maxBtn.click();
        for(int i = 1;i<=timesToLeft;i++){
            move.sendKeys(Keys.ARROW_LEFT).build().perform();
        }
    }
}
