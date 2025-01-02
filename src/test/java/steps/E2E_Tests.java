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

public class E2E_Tests extends TestBase {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    @Given("The user Is on the products page after logging in successfully with I entered {string} , {string}")
    public void the_user_is_on_the_products_page_after_logging_in_successfully_with_i_entered(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.UserCanAddElementLogin(username, password);
        loginPage.UserCanLogin();
        productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.title.getText().equalsIgnoreCase("Products"));
    }
    @When("The user selects Sort by Alphabetic \\(Ascending) from the sorting options")
    public void the_user_selects_sort_by_alphabetic_ascending_from_the_sorting_options() {
        productsPage = new ProductsPage(driver);
        productsPage.UserCanSortByAlphabeticInAscendingOrder();
        Assert.assertTrue(productsPage.firstProdAse.getText().contains("Sauce"));
    }
    @When("I Will Add products to cart from the products page")
    public void i_will_add_products_to_cart_from_the_products_page() {
        productsPage.UserCanAddProducts();
    }
    @When("I will Navigate to Checkout page and entered {string} , {string} ,{string}")
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
    @When("Print to a successfully message and back home")
    public void print_to_a_successfully_message_and_back_home() {
        Assert.assertTrue(checkOutPage.messageSuccessfully.getText().contains("Thank you"));
        checkOutPage.UserCanNavigateToBackHome();
    }
    @When("I will Reset App State from all actions in site")
    public void i_will_reset_app_state_from_all_actions_in_site() throws InterruptedException {
        productsPage.ResetApp();
    }
    @Then("User Logout From Site")
    public void user_logout_from_site() throws InterruptedException {
       productsPage.UserCanLogout();
    }
}
