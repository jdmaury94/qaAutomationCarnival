package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    public WebDriver driver;

    public WebDriver getDriver() {
        String os = System.getProperty("os.name").toLowerCase();
        if(driver==null){
            if(os.contains("mac"))
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
            else
                System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe") ;
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
