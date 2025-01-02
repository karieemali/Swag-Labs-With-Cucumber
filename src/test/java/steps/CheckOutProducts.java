package steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsPage;
import tests.TestBase;

public class CheckOutProducts extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;

    @Given("The user is on the products page after logging in successfully with I entered {string} , {string}")
    public void the_user_is_on_the_products_page_after_logging_in_successfully_with_i_entered(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.UserCanAddElementLogin(username, password);
        loginPage.UserCanLogin();
    }
    @When("I will add products to cart from the products page")
    public void i_will_add_products_to_cart_from_the_products_page() {
        productsPage = new ProductsPage(driver);
        productsPage.UserCanAddProducts();
    }
    @When("I will navigate to Checkout page and entered {string} , {string} ,{string}")
    public void i_will_navigate_to_checkout_page_and_entered(String firstname, String lastname, String postalCode) {

        cartPage = new CartPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2000)");
        cartPage.OpenCheckOutPage();
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.UserCanFillDataToCheckoutProducts(firstname,lastname,postalCode);
        js.executeScript("scrollBy(0,2000)");
        Assert.assertTrue(checkOutPage.totPrice.getText().contains("114"));
        checkOutPage.UserCanFinishCheckoutStep();
    }
    @Then("print to a successfully message and back home")
    public void print_to_a_successfully_message_and_back_home() {
        Assert.assertTrue(checkOutPage.messageSuccessfully.getText().contains("Thank you"));
        checkOutPage.UserCanNavigateToBackHome();
    }
    @Then("User logout from site")
    public void user_logout_from_site() throws InterruptedException {
        productsPage.UserCanLogout();
    }
}
