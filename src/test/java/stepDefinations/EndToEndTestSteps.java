package stepDefinations;

import PageObjects.*;
import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EndToEndTestSteps {

    LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    InventoryPage inventoryPage = new InventoryPage(DriverFactory.getDriver());
    CartPage cartPage = new CartPage(DriverFactory.getDriver());
    CheckOutStepOnePage checkOutStepOnePage = new CheckOutStepOnePage(DriverFactory.getDriver());
    CheckOutOverview checkOutOverview = new CheckOutOverview(DriverFactory.getDriver());
    List<Product> productList = new ArrayList<>();
    double expectedTotal = 0.0;

    @Given("Navigate to base URL {string}")
    public void navigateToBaseURL(String url) {
        DriverFactory.getDriver().get(url);
    }

    @Given("Login to application with below credentials")
    public void login_to_application_with_below_credentials(DataTable dataTable) {
        // Collecting Data from Data Table
        List<Map<String, String>> details = dataTable.asMaps();
        String username = details.get(0).get("username");
        String password = details.get(0).get("password");

        // login page actions
        loginpage.enter_username(username);
        loginpage.enter_password(password);
        loginpage.clickOnLogin();
    }

    @Given("Add below list of products in the cart")
    public void addBelowListOfProductsInTheCart(DataTable dataTable) {
        List<String> products = dataTable.asList();
        products.forEach(product -> {
            Product prod = null;
            if (!product.equals("Products")){
                inventoryPage.addToCart(product);
                prod = new Product();
                prod.setName(product);
                prod.setPrice(inventoryPage.getProductPrice(product));
                productList.add(prod);
            }});
    }

    @Given("Open cart")
    public void open_cart() {
        inventoryPage.openCart();
    }

    @Given("Check products count in the cart")
    public void check_products_count_in_the_cart() {
        Assert.assertEquals(productList.size(), cartPage.getNumberOfItemsInCart());
    }

    @When("Click on checkout")
    public void click_on_checkout() {
        cartPage.clickOnCheckOut();
    }

    @When("Add check out info")
    public void add_check_out_info(io.cucumber.datatable.DataTable dataTable) {
        // Collecting Data from Data Table
        List<Map<String, String>> details = dataTable.asMaps();
        String firstName = details.get(0).get("firstname");
        String lastName = details.get(0).get("lastname");
        String postalCode = details.get(0).get("zip");

        // login page actions
        checkOutStepOnePage.enterFirstName(firstName);
        checkOutStepOnePage.enteLastName(lastName);
        checkOutStepOnePage.enterPostalCode(postalCode);
    }

    @And("click on continue")
    public void clickOnContinue() {
        checkOutStepOnePage.clickOnContinue();
    }

    @Then("Check Item total of the Products")
    public void check_of_the_products() {
        for(Product product : productList){
            expectedTotal += product.getPrice();
        }
        Assert.assertEquals(checkOutOverview.getItemTotal(), expectedTotal);
    }

    @Then("Check Total Price")
    public void check() {
        double expectedFinalPrice = expectedTotal + checkOutOverview.getTax();
        Assert.assertEquals(checkOutOverview.getFinalTotal(),expectedFinalPrice);
    }

    @Then("Click on Finish")
    public void click_on_finish() {
        checkOutOverview.clickOnFinished();
    }

}
