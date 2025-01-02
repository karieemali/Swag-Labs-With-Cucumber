package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import tests.TestBase;

public class AddProducts extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;


    @Given("the user is on the products page after logging in successfully with I entered {string} , {string}")
    public void the_user_is_on_the_products_page_after_logging_in_successfully_with_i_entered(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.UserCanAddElementLogin(username, password);
        loginPage.UserCanLogin();
    }
    @When("I add products to cart from the products page")
    public void i_add_products_to_cart_from_the_products_page() {
        productsPage = new ProductsPage(driver);
        productsPage.UserCanAddProducts();
    }
    @When("I remove products to cart from the cart page")
    public void i_remove_products_to_cart_from_the_cart_page() {
        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.titleCartPage.getText().contains("Cart"));
        cartPage.UserCanRemoveProducts();
    }
    @Then("user logout from site")
    public void user_logout_from_site() throws InterruptedException {
        productsPage.UserCanLogout();
    }

}
