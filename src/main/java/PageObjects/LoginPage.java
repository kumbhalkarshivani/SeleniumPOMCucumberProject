package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class LoginPage extends TestBase {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By login_button = By.id("login-button");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enter_username(String name){
        enterText(username, name);
    }
    public void enter_password(String pwd){
        enterText(password, pwd);
    }

    public void clickOnLogin(){
        click(login_button);
    }

}
