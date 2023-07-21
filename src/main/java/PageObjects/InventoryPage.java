package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ScrollHelper;
import utilities.TestBase;

public class InventoryPage extends TestBase {

    private final String addToCartButton = "//div[contains(text(),'param')]/ancestor::div[@class='inventory_item_description']/descendant::button";
    private final String productPrice = "//div[contains(text(),'param')]/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price']";
    By cart = By.className("shopping_cart_link");
    ScrollHelper scroller;

    public InventoryPage(WebDriver driver){
        super(driver);
        scroller = new ScrollHelper(driver);
    }

    public void addToCart(String productName){
        addWait();
        By locator = setLocator(addToCartButton,productName);
        scroller.scrollTillElementIsVisible(getWebElement(locator));
        click(locator);
    }

    public void openCart(){
        scroller.scrollTillElementIsVisible(getWebElement(cart));
        click(cart);
    }

    public double getProductPrice(String productName){
        By locator = setLocator(productPrice,productName);
        String priceText = getTextValue(locator);
        return getPriceFromText(priceText);
    }
}
