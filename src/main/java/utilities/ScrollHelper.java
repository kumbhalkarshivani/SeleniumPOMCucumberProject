package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollHelper {
    WebDriver driver;
    JavascriptExecutor js;

    public ScrollHelper(WebDriver driver){
        this.driver = driver;
       js = (JavascriptExecutor) driver;
    }

    public void scrollTillElementIsVisible(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
