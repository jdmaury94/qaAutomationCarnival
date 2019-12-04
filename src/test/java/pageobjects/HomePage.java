package pageobjects;

import helpers.Helpers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;


public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Helpers helpers;

    @FindBy(id="cdc-destinations")
    public WebElement sailTo;

    @FindBy(id="cdc-durations")
    public WebElement duration;

    @FindBy(id="sfn-nav-pricing")
    public WebElement pricingFilter;

    @FindBy(className = "sbsc-container__reset-selections")
    public WebElement resetFilter;

    @FindBy(className = "cdc-filters-wrapper")
    public WebElement sailsBox;

    public HomePage(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers();
        PageFactory.initElements(driver,this);
    }

    public void selectSail(String sail){
        sailTo.click();
        WebElement destination = driver.findElement(By.xpath("//button[contains(text(),'"+sail+"')]"));
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.and( ExpectedConditions.visibilityOf(destination),
                ExpectedConditions.elementToBeClickable(destination)));
        destination.click();
    }

    public void setDuration(int a, int b){
        duration.click();
        String textContent = a+" - "+b+" Days";
        String xpath = "//button[contains(text(),'"+textContent+"')]";
        WebElement duration = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.and( ExpectedConditions.visibilityOf(duration),
                ExpectedConditions.elementToBeClickable(duration)));
        duration.click();
    }

    public boolean checkResultsOnGrid(){
        WebElement results = driver.findElement(By.tagName("ccl-view-result-container"));
        WebElement resultsGrid = driver.findElement(By.className("sbls-container__layout-swichers-button"));
        if(results!=null && resultsGrid!=null)
            return true;
        else
            return false;
    }

    public void priceFilterClick(){
        pricingFilter.click();
    }

    public void filterByPrice(int minPrice,int maxPrice){
        WebElement minVal = driver.findElement(By.className("rz-pointer-min"));
        WebElement maxVal = driver.findElement(By.className("rz-pointer-max"));
        helpers.sendKeysNTimes(minPrice,maxPrice,minVal,maxVal,driver);
    }

    public boolean checkOrderedPrices(){
        wait.until(ExpectedConditions.and( ExpectedConditions.visibilityOf(resetFilter),
                ExpectedConditions.elementToBeClickable(resetFilter)));
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='vrgf-price-box__price']"));
        List<Integer> pricesList = new ArrayList<>();
        for (WebElement el : list) {
            pricesList.add(helpers.formatStringToNumber(el.getText()));
        }
        return helpers.checkSortedList(pricesList);
    }
}
