package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class CartPage extends TestBase {

    private final By cartItems = By.className("cart_item");
    private final By checkOutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfItemsInCart(){
        List<WebElement> items = getWebElements(cartItems);
        return items.size();
    }

    public void clickOnCheckOut(){
        click(checkOutButton);
    }

}
