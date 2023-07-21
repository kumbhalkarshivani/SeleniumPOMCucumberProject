package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class CheckOutOverview extends TestBase {

    private final By itemTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By finalTotal = By.xpath("//div[contains(@class,'summary_total_label')]");
    private final By finished = By.id("finish");

    public CheckOutOverview(WebDriver driver) {
        super(driver);
    }

    public double getItemTotal(){
        String value = getTextValue(itemTotal);
        return getPriceFromText(value);
    }
    public double getTax(){
        String value = getTextValue(tax);
        return getPriceFromText(value);
    }
    public double getFinalTotal(){
        String value = getTextValue(finalTotal);
        return getPriceFromText(value);
    }
    public void clickOnFinished(){
        click(finished);
    }
}
