package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class TestBase extends WaitManager{
    private WebDriver driver;
    private Actions action;

    public TestBase(WebDriver driver){
        super(driver);
        this.driver=driver;
        this.action = new Actions(driver);
    }
    protected void click(By locator){driver.findElement(locator).click();}
    protected void click(WebElement element){
        element.click();
    }
    protected void enterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    protected String getTextValue(By locator){
        return driver.findElement(locator).getText();
    }
    protected String getAttributeValue(By locator, String attribute){return driver.findElement(locator).getAttribute(attribute);}
    protected WebElement getWebElement(By locator){return driver.findElement(locator);}
    protected List<WebElement> getWebElements(By locator){
        return driver.findElements(locator);
    }
    protected By setLocator(String locator, String param){
        return By.xpath(locator.replace("param",param));
    }
    protected void doubleClick(By locator){
        action.doubleClick(getWebElement(locator)).perform();
    }
    protected void rightClick(By locator){
        action.contextClick(getWebElement(locator)).perform();
    }
    protected void closeNewTab(){
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        addWait();
        driver.switchTo().window(browserTabs .get(1));
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }
    protected double getPriceFromText(String stringPrice){
        return Double.parseDouble(stringPrice.split("\\$")[1]);
    }
}
