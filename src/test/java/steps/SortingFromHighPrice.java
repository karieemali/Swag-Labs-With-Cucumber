package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import tests.TestBase;

public class SortingFromHighPrice extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    @Given("the user is on the products page after Logging in Successfully With I enter {string} , {string}")
    public void the_user_is_on_the_products_page_after_logging_in_successfully_with_i_enter(String username, String password) throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.UserCanAddElementLogin(username, password);
        loginPage.UserCanLogin();
        Thread.sleep(1000);
    }
    @When("the user selects Sort by Price \\(High) from the sorting options")
    public void the_user_selects_sort_by_price_high_from_the_sorting_options() {
        productsPage = new ProductsPage(driver);
        productsPage.UserCanSortByHighPriceOrder();
    }
    @Then("all products should be displayed in High Price order")
    public void all_products_should_be_displayed_in_high_price_order() throws InterruptedException {
        Assert.assertTrue(productsPage.highPrice.getText().contains("49.99"));
        productsPage.UserCanLogout();
    }
}
