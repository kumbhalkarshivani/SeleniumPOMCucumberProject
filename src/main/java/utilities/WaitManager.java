package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class WaitManager {
    WebDriver driver;
    Integer standardTimeout = 5;

    public WaitManager(WebDriver driver){
        this.driver = driver;
    }
    public void addWait(Integer... timeout){
        if(timeout.length == 0){
            driver.manage().timeouts().implicitlyWait(standardTimeout, TimeUnit.SECONDS);
        }else {
            driver.manage().timeouts().implicitlyWait(timeout[0], TimeUnit.SECONDS);
        }
    }
    public void addWait(By element, Integer... timeout){
        WebDriverWait wait;
        if(timeout.length == 0){
             wait = new WebDriverWait(driver, standardTimeout);
        }else {
            wait = new WebDriverWait(driver, timeout[0]);
        }
        wait.until(elementToBeClickable(element));
    }
}
