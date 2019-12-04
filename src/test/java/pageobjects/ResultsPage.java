package pageobjects;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultsPage {
    public WebDriver driver;
    public Helpers helpers;

    @FindBy(className = "about-cta")
    List<WebElement> learnMoreBtns;

    @FindBy(xpath = "//span[text()='Book Now']")
    List<WebElement> bookNowBtn;

    public ResultsPage(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers();
        PageFactory.initElements(driver,this);
    }

    public void selectRandomCruise(){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<String> resultsIds = helpers.getResultsIds(driver);
        String randomUuid = resultsIds.get(helpers.randomIndex(resultsIds));
        String xpath = "//div[@data-itinerary-uuid='"+randomUuid+"']";
        WebElement randomCruise = driver.findElement(By.xpath(xpath));
        randomCruise.click();
    }

    public boolean itineraryIsOpened(){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = driver.getCurrentUrl();
        if(url.contains("itinerary"))
            return true;
        return false;

    }

    public void clickLearnMoreBtns(){
        System.out.println(learnMoreBtns.size());
        WebDriverWait wait = new WebDriverWait(driver,10);
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        for (WebElement el : learnMoreBtns) {
            executor.executeScript("arguments[0].click()", el);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='details']")));
            WebElement element = driver.findElement(By.xpath("//*[contains(@ng-click, 'closeDay')]"));
            executor.executeScript("arguments[0].click()", element);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='details']")));

        }
    }

    public boolean checkBookNowBtn(){
        if(bookNowBtn.size()>0)
            return true;
        return false;
    }
}
