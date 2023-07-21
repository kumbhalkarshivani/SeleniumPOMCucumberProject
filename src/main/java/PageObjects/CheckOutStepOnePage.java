package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class CheckOutStepOnePage extends TestBase {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckOutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String fname){
        enterText(firstName,fname);
    }

    public void enteLastName(String lname){
        enterText(lastName,lname);
    }

    public void enterPostalCode(String code){
        enterText(postalCode,code);
    }

    public void clickOnContinue(){
        click(continueButton);
    }
}
